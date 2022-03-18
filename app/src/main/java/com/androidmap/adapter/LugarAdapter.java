package com.androidmap.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidmap.MapActivity;
import com.androidmap.R;
import com.androidmap.model.Lugar;

import java.util.ArrayList;

public class LugarAdapter extends RecyclerView.Adapter<LugarAdapter.LugarViewHolder> {

    private ArrayList<Lugar> lugares;
    private Activity activity;

    public LugarAdapter(ArrayList<Lugar> lugares, Activity activity) {
        this.lugares = lugares;
        this.activity = activity;
    }

    @NonNull
    @Override
    public LugarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_lugar, parent, false);
        return new LugarViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LugarViewHolder holder, int position) {
        Lugar lugar = lugares.get(position);

        holder.imgLugar.setImageResource(lugar.getImagen());
        holder.tvNombreLugar.setText(lugar.getNombre());

        holder.imgLugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), MapActivity.class);
                intent.putExtra("lugarLat", lugar.getCoordenadas().latitude);
                intent.putExtra("lugarLng", lugar.getCoordenadas().longitude);
                intent.putExtra("nombreLugar", lugar.getNombre());
                activity.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return lugares.size();
    }


    public class LugarViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgLugar;
        private TextView tvNombreLugar;

        public LugarViewHolder(@NonNull View itemView) {
            super(itemView);

            imgLugar = itemView.findViewById(R.id.imgLugar);
            tvNombreLugar = itemView.findViewById(R.id.tvNombreLugar);

        }
    }
}
