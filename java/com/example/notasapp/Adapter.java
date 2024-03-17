package com.example.notasapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    LayoutInflater inflater;
    List<NotaModelo> notasModel;

    Adapter (Context context, List<NotaModelo>notasModel){
        this.inflater=LayoutInflater.from(context);
        this.notasModel=notasModel;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.note_view,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        String titulo = notasModel.get(position).getTitulo();
        String fecha = notasModel.get(position).getFecha();
        String hora = notasModel.get(position).getHora();

        holder.nTitulo.setText(titulo);
        holder.nFecha.setText(fecha);
        holder.nHora.setText(hora);

    }

    @Override
    public int getItemCount() {
        return notasModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nTitulo, nFecha, nHora;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nTitulo = itemView.findViewById(R.id.nTitulo);
            nFecha = itemView.findViewById(R.id.nFecha);
            nHora = itemView.findViewById(R.id.nHora);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), Detalles.class);
                    intent.putExtra("ID", notasModel.get(getAdapterPosition()).getId());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
