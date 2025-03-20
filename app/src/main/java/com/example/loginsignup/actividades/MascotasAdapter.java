package com.example.loginsignup.actividades;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.loginsignup.R;
import com.example.loginsignup.baseDatos.entidades.Mascota;
import java.util.List;

public class MascotasAdapter extends RecyclerView.Adapter<MascotasAdapter.MascotaViewHolder> {

    private List<Mascota> listaMascotas;
    private OnMascotaClickListener listener;

    public MascotasAdapter(List<Mascota> listaMascotas, OnMascotaClickListener listener) {
        this.listaMascotas = listaMascotas;
        this.listener = listener;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mascota, parent, false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, int position) {
        Mascota mascota = listaMascotas.get(position);
        holder.nombreMascota.setText(mascota.nombre);
        holder.tipoMascota.setText(mascota.tipo);

        holder.itemView.setOnClickListener(v -> listener.onMascotaClick(mascota));
    }

    @Override
    public int getItemCount() {
        return listaMascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        TextView nombreMascota, tipoMascota;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            nombreMascota = itemView.findViewById(R.id.textViewNombreMascota);
            tipoMascota = itemView.findViewById(R.id.textViewTipoMascota);
        }
    }

    public interface OnMascotaClickListener {
        void onMascotaClick(Mascota mascota);
    }
}

