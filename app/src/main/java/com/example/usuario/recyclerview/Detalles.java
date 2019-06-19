package com.example.usuario.recyclerview;

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.usuario.recyclerview.MainActivity.EXTRA_DESCRIPTION;
import static com.example.usuario.recyclerview.MainActivity.EXTRA_NAME;
import static com.example.usuario.recyclerview.MainActivity.EXTRA_URL;




public class Detalles extends AppCompatActivity {

    TextView nombre;
    TextView infocorta;
    TextView info;
    ImageView imagen;
    ImageButton favs;
    String direccion, mensaje, asunto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.descripcion);
        Bundle b = getIntent().getExtras();
        nombre= findViewById(R.id.idNombreDetalles);
        infocorta = findViewById(R.id.idInfoDetallesmini);
        info=findViewById(R.id.idInfoDetalles);
        imagen = findViewById(R.id.idImageDetalles);
        favs = findViewById(R.id.favbtn);


        Hardware hw = (Hardware)b.getSerializable("id1");
       nombre.setText(hw.getNombre());
       infocorta.setText(hw.getInfo());
       info.setText(hw.getInfolarga());
       imagen.setImageResource(hw.getFotoid());
       direccion = hw.getURL();
       if(hw.isFavorito()==true) {
           favs.setImageResource(R.mipmap.ic_launcher_favllen);
       } else {
           favs.setImageResource(R.mipmap.ic_launcher_favacio);

       }

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detalles_menus, menu);
        MenuItem itemnavegar = menu.findItem(R.id.navegar_id);
        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item) {
        int option = item.getItemId();
        Bundle b = getIntent().getExtras();
        Hardware hw = (Hardware)b.getSerializable("id1");
if(option == R.id.navegar_id) {
    Intent navegar = new Intent(Intent.ACTION_VIEW, Uri.parse(direccion));
    startActivity(navegar);
    Toast.makeText(Detalles.this,
            "Redirigiendo", Toast.LENGTH_LONG).show();
}
        if(option == R.id.compartir_id) {
    Intent compartir = new Intent(Intent.ACTION_SEND);
    compartir.setType("text/plain");
    mensaje = hw.getInfo();
    asunto = hw.getNombre();
    compartir.putExtra(Intent.EXTRA_SUBJECT, asunto);
    compartir.putExtra(Intent.EXTRA_TEXT, mensaje);
    startActivity(Intent.createChooser(compartir, "Compartir por..."));

        }
        if(option == R.id.email_id) {
            Intent cartear = new Intent(Intent.ACTION_SENDTO);
            cartear.setType("text/plain");
            mensaje = hw.getInfo();
            asunto = hw.getNombre();
            cartear.putExtra(Intent.EXTRA_EMAIL, "usuario@dominio.com");
            cartear.putExtra(Intent.EXTRA_SUBJECT, asunto);
            cartear.putExtra(Intent.EXTRA_TEXT, mensaje);
            startActivity(Intent.createChooser(cartear, "enviar correo"));


        }

        return false;
    }


        public void onClick(View view) {
        MainActivity actividad = new MainActivity();


        Bundle b = getIntent().getExtras();

        Hardware hw = (Hardware)b.getSerializable("id1");
       

        if(hw.isFavorito()==true) {
            favs.setImageResource(R.mipmap.ic_launcher_favacio);

            Toast.makeText(Detalles.this,
                    "Eliminado de favoritos", Toast.LENGTH_LONG).show();

        } else {
            favs.setImageResource(R.mipmap.ic_launcher_favllen);
            Toast.makeText(Detalles.this,
                    "Añadido a favoritos", Toast.LENGTH_LONG).show();


        }


    }
}
