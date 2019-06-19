package com.example.usuario.recyclerview;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

 ;
    String nombre;
    String infocorta;
    String infolarga;
    String url;
    String videoid;
    int fotoid;
    String direccion, mensaje, asunto;



    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("portapapeles", nombre);
                clipboard.setPrimaryClip(clip);

                Snackbar.make(view, "Copiado al portapapeles", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        fab.setOnLongClickListener(new View.OnLongClickListener() {
                                        public boolean onLongClick(View v) {
                                            Toast.makeText(v.getContext(), "Guarda el nombre del componente en el pisapapeles", Toast.LENGTH_SHORT).show();
                                            return true;
                                        }
                                    });


        Bundle b = getIntent().getExtras();
        Hardware hw = (Hardware)b.getSerializable("id1");
         nombre= hw.getNombre();
         infocorta = hw.getInfo();
         infolarga = hw.getInfolarga();
         url = hw.getURL();
         fotoid = hw.getFotoid();
         videoid = hw.getVideoid();

        Toast.makeText(SecondActivity.this,
                nombre, Toast.LENGTH_LONG).show();



//        Fragment fragment2 = new Fragment();
        InfoFragment info = new InfoFragment();

        Bundle bundle = new Bundle();


        // String name = componentes.get(pos).getNombre();
        bundle.putString("name", nombre);
        bundle.putString("infoshort", infocorta);
        bundle.putString("infolong", infolarga);
        bundle.putString("url", url);
        bundle.putInt("photo", fotoid);


        info.setArguments(bundle);

       // Toast.makeText(SecondActivity.this,
             //   nombre, Toast.LENGTH_LONG).show();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.detalles_menus, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Bundle b = getIntent().getExtras();
        Hardware hw = (Hardware)b.getSerializable("id1");
        if(id == R.id.navegar_id) {
            Intent navegar = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(navegar);
            Toast.makeText(SecondActivity.this,
                    "Redirigiendo", Toast.LENGTH_LONG).show();
        }
        if(id == R.id.compartir_id) {
            Intent compartir = new Intent(Intent.ACTION_SEND);
            compartir.setType("text/plain");
            mensaje = hw.getInfo();
            asunto = hw.getNombre();
            compartir.putExtra(Intent.EXTRA_SUBJECT, asunto);
            compartir.putExtra(Intent.EXTRA_TEXT, mensaje);
            startActivity(Intent.createChooser(compartir, "Compartir por..."));

        }
        if(id == R.id.email_id) {
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


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_second, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:

                  InfoFragment fragment1 = new InfoFragment();

                    Bundle bundle = new Bundle();

                    bundle.putString("name", nombre);
                    bundle.putString("infoshort", infocorta);
                    bundle.putString("infolong", infolarga);
                    bundle.putString("url", url);
                    bundle.putInt("photo", fotoid);



                    fragment1.setArguments(bundle);
                  return fragment1;

                case 1:
                    VideoFragment fragment2 = new VideoFragment();
                    Bundle b = new Bundle();
                    b.putString("video", videoid);
                  //  b.putString("name", nombre);
                    fragment2.setArguments(b);

                    return fragment2;
            }
            return null;
        }



        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }
    }



}



