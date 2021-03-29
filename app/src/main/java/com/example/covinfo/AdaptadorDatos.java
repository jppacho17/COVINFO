package com.example.covinfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.util.ArrayList;

public class AdaptadorDatos extends Adapter<AdaptadorDatos.ViewHolderDatos> {

    ArrayList<DatosUsuario> listaDatos;

    public AdaptadorDatos(ArrayList<DatosUsuario> listaDatos) {
        this.listaDatos = listaDatos;
    }

    @Override
    public AdaptadorDatos.ViewHolderDatos onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_datos,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(AdaptadorDatos.ViewHolderDatos holder, int position) {

        holder.txtfecha.setText(listaDatos.get(position).getFecha());
        holder.txtTemperatura.setText(listaDatos.get(position).getTemperatura());
        holder.txtPCR.setText(listaDatos.get(position).getPcrPos());

    }

    @Override
    public int getItemCount() {
        return listaDatos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView txtfecha, txtTemperatura, txtPCR;

        public ViewHolderDatos(View itemView) {
            super(itemView);

            txtfecha=(TextView) itemView.findViewById(R.id.txtFechaItem);
            txtTemperatura=(TextView) itemView.findViewById(R.id.txtTempItem);
            txtPCR=(TextView) itemView.findViewById(R.id.txtPCRItem);

        }
    }

}
