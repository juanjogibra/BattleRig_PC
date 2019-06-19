package com.example.usuario.recyclerview;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity  {

    public static final String EXTRA_URL = "imageUrl";
    public static final String EXTRA_NAME = "componentName";
    public static final String EXTRA_DESCRIPTION = "DescriptionName";
    ArrayList<Hardware> componentes;
    RecyclerView rv;
    AdapterDatos adaptador;
    int pos=0;

    public void setComponentes(ArrayList<Hardware> componentes) {
        this.componentes = componentes;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rv = findViewById(R.id.recyclerId);
        rv.setLayoutManager(new LinearLayoutManager(this));

        componentes = new ArrayList<>();

        rv.setLayoutManager(new LinearLayoutManager(this));

        llenarComponentes();

         adaptador = new AdapterDatos(componentes);
        rv.setAdapter(adaptador);

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrirDellates = new Intent(MainActivity.this, Detalles.class);
                Intent segundaActividad = new Intent(MainActivity.this, SecondActivity.class);

                Hardware pieza = componentes.get(rv.getChildAdapterPosition(v));
                pos=rv.getChildAdapterPosition(v);
                Bundle b = new Bundle();
                b.putSerializable("id1", pieza);
                abrirDellates.putExtras(b);
                segundaActividad.putExtras(b);

                //  startActivity(abrirDellates);
                startActivity(segundaActividad);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        MenuItem itemsearch = menu.findItem(R.id.search_id);
        SearchView sv = (SearchView) itemsearch.getActionView();
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
            adaptador.getFilter().filter(s);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemSelect= item.getItemId();
        switch (itemSelect){

        }

        return super.onOptionsItemSelected(item);
    }

    private void llenarComponentes() {
        componentes.add(new Hardware("Ryzen 5 2600", "Procesador de la segunda generación de la familia Ryzen AMD.",
                "Te presentamos el AMD Ryzen 5 2600, un procesador que cuenta con 6 núcleos, socket AMD AM4 y arquitectura de 64 bits. Y es que la forma de contratacar de AMD ha sido contundente, lo nuevos Ryzen no solo demuestran mayor efectividad si no tambien un consumo mucho más contenido que sus predecesores. Los procesadores AMD Ryzen están diseñados para satisfacer las necesidades de los usuarios más avanzados y exigentes. Para minimizar la latencia de respuesta AMD lanza la tecnología Turbo Core que dará la mayor frecuencia del núcleo cuando lo necesita", R.drawable.r52600, false, "https://www.amd.com/es/ryzen-5", "isjBwbTafro"));
        componentes.add(new Hardware("Asus Rog B350", "Placa Base Asus Rog Gaming Chipset AMD B350.", "Powered by AMD Ryzen AM4, 7th generation Athlon and HD 2000 series processors to maximize connectivity and speed with NVMe M.2, USB 3.1, gigabit LAN, and up to 64GB of DDR4\n" +
                "5-Way Optimization with Auto-Tuning and Fan Xpert 4 automatically tailors overclocking profiles to your unique build for maximum OC performance and dynamic system cooling. Operating System: Windows 10 64-bit\n" +
                "AURA Sync RGB lighting plus additional 4-pin RGB headers provides a nearly endless spectrum of colors with the ability to synchronize effects across an ever-expanding ecosystem of AURA Sync enabled products", R.drawable.asusrog, true, "https://www.asus.com/us/Motherboards/ROG-STRIX-B350-F-GAMING/", "IN8TIHlGWFc"));
        componentes.add(new Hardware("G.Skill Trident Z 16GB", "Combo 2x8 GB Memoria RAM DDR4 CL16 2600Mhz.",
                "La nueva gama de memorias RAM G.Skill Trident Z RGB ofrece soluciones para un rendimiento increíble. Estos kits optimizan el rendimiento de las plataformas de nueva generación, con la ventaja añadida de un alto potencial de overclocking. Además, estas rápidas memorias incorporan un sistema de iluminación LED RGB con hasta 16.8 millones de colores con varios modos de iluminación por software. Simplemente pincha la memoria Trident Z RGB en tu placa basey disfruta de la iluminación.", R.drawable.gskill, false, "https://gskill.com/en/finder?cat=31&series=2482", "ALuJGVutHcs"));
        componentes.add(new Hardware("Seasonic 80 plus", "Fuente de Alimentación Seasonic 80 plus silver 520Watt no modular.", "Seasonic es una empresa que tiene una larga trayectoria en lo que respecta a fuentes de alimentación de alto rendimiento. Sus modelos siguen superándose para brindarle la mejor calidad en cuanto a potencia/prestaciones/consumo y por sobre todas las cosas nivel sonoro de la unidad. Tal es así que la serie S12II pone especial énfasis en todo lo enumerado anteriormente. \n" +
                "Además de su gran eficiencia, por la que es merecedora de la certificación 80 Plus Bronze, destaca por la excelente estabilidad y seguridad que le otorgan su circuito dual avanzado y sus múltiples salidas de 12V.", R.drawable.seasonic, false, "https://seasonic.com/", "Hb0exfyDJ24"));
        componentes.add(new Hardware("San Disk SSD 240 GB", "Disco estado solido 240 GB Sata III.",
                "Te presentamos el SSD Plus 240GB de SanDisk, un disco SSD confiable, rápido y con mucha capacidad. SanDisk, pionera en tecnologías de almacenamiento de estado sólido y la marca en la que confían los profesionales, ofrece una mejora de la velocidad y el rendimiento con la unidad SanDisk SSD Plus. Con velocidades de lectura secuencial de hasta 535 MB/s**, esta unidad de estado sólido es hasta 20 veces más rápida que una unidad de disco duro típica1. Valorarás los arranques, los apagados, las transferencias de datos y los tiempos de respuesta de las aplicaciones más rápidos que con una unidad de disco duro1. La unidad SanDisk SSD Plus también ofrece un rendimiento silencioso y fiable, y la supervisión del estado del tablero4 para tus aplicaciones de medios favoritas.", R.drawable.sandisk, false, "https://www.sandisk.es/home/ssd/ssd-plus", "RM5pOGTsxy8"));
        componentes.add(new Hardware("Gigabyte Gaming 1070ti", "Tarjeta gráfica Nvidia GTX 1070ti 8GB GDDR5.", "En las Nvidia GTX 1070 se utiliza la tecnología FinFET para fabricar la GPU con una arquitectura de 16 nm (nanómetros). Dicha tecnología le permite alcanzar velocidades mucho más altas con un consumo ostensiblemente menor, permitiendo integrar 17.000 millones de transistores, que son las unidades básicas de procesamiento de cualquier procesador.\n" +
                "\n" +
                "Pascal dobla, e incluso triplica en entornos de realidad virtual, la potencia de la nueva serie de Nvidia a la vez que reduce su consumo. Un portento de la ciencia puesto al alcance de cualquiera, que ha sido desarrollado durante años para que hoy pueda ser posible disfrutar de ella en tu Pc Master Race.", R.drawable.grafica, true, "https://www.gigabyte.com/Graphics-Card/GV-N107TGAMING-8GD#kf", "5kQvJ7A3gPU"));
        componentes.add(new Hardware("MasterBox Lite 3.1 TG", "Caja PC Gaming. Incluye 3 ventiladores RGB",
                "MasterBox Lite 3.1 TG, la opción directa para la compilación de su PC que no ignora el buen aspecto, la personalización o el rendimiento. Un elegante panel frontal DarkMirror y tres colores de recorte personalizados (incluidos en la caja) ofrecen un excelente primer punto de entrada para la personalización. Además, viene con un panel lateral de vidrio templado borde a borde de 4 mm para mostrar sus componentes internos. Y con soporte para hasta 3 ventiladores de refrigeración y un sistema de refrigeración por agua, nos aseguramos de que su rendimiento no sufra.", R.drawable.td5, true, "http://www.coolermaster.com/case/mini-tower/masterbox-lite-3-1-tg/", "hj3VsDAPbnY"));
        componentes.add(new Hardware("Razer Chroma", "Teclado mecánico RGB switches cherry MX red.",
                "Te presentamos el teclado mecánico BlackWidow Chroma V2 de Razer. ElRazer BlackWidow Chroma V2es un teclado mecánico RGB que permite increíbles configuraciones así como distintos modos LED configurables durante el juego, a la vez que mantiene un diseño elegante y compacto. Elige entre 16,8 millones de colores para adaptar y transformar Razer BlackWidow Chroma V2en tu propio y único estilo de juego.", R.drawable.chroma, false, "https://www.razer.com/chroma", "J7KUsYUzp9g"));
        componentes.add(new Hardware("Razer Mamba", "Raton Gaming 10000dpi. Cable 1.2 metros de longitud.",
                "El sensor de ratón para juegos más preciso del mundo, con 16 000 ppp Equipado con el sensor de ratón para juegos más preciso del mundo, con 16 000 ppp, el Razer Mamba Tournament Edition ofrece una precisión incomparable, de modo que obtendrás una ventaja aún mayor en la competición. Con capacidad para rastrear incrementos de hasta 1 ppp y distancias de elevación de hasta 0,1 mm, el Razer Mamba Tournament Edition te ayudará a reaccionar instantáneamente al maniobrar para abrirte camino hasta la victoria.", R.drawable.mamba, false, "https://www2.razer.com/es-es/gaming-mice/razer-mamba", "EVdjYjYq6So"));
        componentes.add(new Hardware("AOC 24' ", "Monitor AOC 24 pulgadas 1920x1080 60GHZ.",
                "Para casa o el trabajo, esta pantalla ofrece un rendimiento excelente con 16,7 millones de colores y un tiempo de respuesta de 1 ms. Las características inteligentes como el modo Eco o e-Saver te ayudan a reducir sin esfuerzo el consumo de energía.", R.drawable.aoc, false, "https://eu.aoc.com/es/", "Rq2HJkg6BGg"));


    }
    public boolean onSearchRequested() {
        pauseSomeStuff();
        return super.onSearchRequested();
    }

    private void pauseSomeStuff() {
    }
}
