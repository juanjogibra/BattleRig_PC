package com.example.usuario.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;



public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos>
implements View.OnClickListener, Filterable  {

    ArrayList<Hardware> componentes;
    ArrayList<Hardware> componentestotales;
    private View.OnClickListener mlistener;

    public AdapterDatos(ArrayList<Hardware> componentes) {
        this.componentes = componentes;
        componentestotales = new ArrayList<>(componentes);
    }

    @Override
    public ViewHolderDatos onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null, false);
        view.setOnClickListener(this);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderDatos holder, int position) {
        holder.elnombre.setText(componentes.get(position).getNombre());
        holder.lainfo.setText(componentes.get(position).getInfo());
        holder.laimagen.setImageResource(componentes.get(position).getFotoid());

    }

    @Override
    public int getItemCount() {
        return componentes.size();
    }


    public void setOnClickListener(View.OnClickListener mlistener) {

        this.mlistener = mlistener;
    }

    @Override
    public void onClick(View v) {
        if (mlistener != null) {
            mlistener.onClick(v);

        }
    }

    @Override
    public Filter getFilter() {
        return examplefilter;
    }
    private Filter examplefilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
           ArrayList<Hardware> listafiltrada = new ArrayList<>();
           if (constraint==null || constraint.length()==0) {
               listafiltrada.addAll(componentestotales);
           } else {
               String filterpattern = constraint.toString().toLowerCase().trim();
               for (Hardware hard: componentestotales) {
                   if(hard.getNombre().toLowerCase().contains(filterpattern)) {
                       listafiltrada.add(hard);
                   }
               }
           }
           FilterResults resultados = new FilterResults();
           resultados.values = listafiltrada;
            return resultados;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
componentes.clear();
componentes.addAll((ArrayList)results.values);
notifyDataSetChanged();
        }
    };

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView elnombre, lainfo;
        ImageView laimagen;

        public ViewHolderDatos(View itemView) {

            super(itemView);
            elnombre = itemView.findViewById(R.id.idNombre);
            lainfo = itemView.findViewById(R.id.idInfo);
            laimagen = itemView.findViewById(R.id.idImage);

        }
    }
}


