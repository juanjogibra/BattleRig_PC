package com.example.usuario.recyclerview;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;


public class InfoFragment extends Fragment {
    private TextView nombre;
    private TextView infocorta;
    private TextView info;
    private ImageView imagen;
    private ImageButton favs;






    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_info, container, false);
        nombre = (TextView)v.findViewById(R.id.idNombreDetalles2);
         infocorta = (TextView)v.findViewById(R.id.idInfoDetallesmini2);
         info = (TextView)v.findViewById(R.id.idInfoDetalles2);
         imagen = (ImageView) v.findViewById(R.id.idImageDetalles2);
         favs = (ImageButton) v.findViewById(R.id.favbtn2);
      // Bundle bundle = getArguments();
        String nama = null;
        String infa=null;
        String infal = null;
        int fota;
        Bundle bundle = getArguments();
        if (bundle != null) {
            nama = bundle.getString("name");
            nombre.setText(nama);
            infa = bundle.getString("infoshort");
            infocorta.setText(infa);
            infal = bundle.getString("infolong");
            info.setText(infal);
            fota=bundle.getInt("photo");
            imagen.setImageResource(fota);
        }

        //Toast.makeText(getActivity(),data,Toast.LENGTH_SHORT).show();

//nombre.setText(getArguments().getString("name"));
        // Hardware hw = (Hardware)b.getSerializable("id1");
       // nombre.setText(hw.getNombre());
      // nombre.setText(name);



        return v;
    }

    String direccion, mensaje, asunto;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);



      /*  Bundle b = getArguments();
        Hardware hw = (Hardware)b.getSerializable("id1");
*/
      // nombre.setText(hw.getNombre());
        /*
        infocorta.setText(hw.getInfo());
        info.setText(hw.getInfolarga());
        imagen.setImageResource(hw.getFotoid());
        direccion = hw.getURL();
        if(hw.isFavorito()==true) {
            favs.setImageResource(R.mipmap.ic_launcher_favllen);
        } else {
            favs.setImageResource(R.mipmap.ic_launcher_favacio);

        }
*/
    }

}
