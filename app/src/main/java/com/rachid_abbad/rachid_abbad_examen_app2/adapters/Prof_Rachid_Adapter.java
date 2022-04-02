package com.rachid_abbad.rachid_abbad_examen_app2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.rachid_abbad.rachid_abbad_examen_app2.R;
import com.rachid_abbad.rachid_abbad_examen_app2.classes.Prof_Rachid;

import java.util.List;

public class Prof_Rachid_Adapter extends RecyclerView.Adapter<Prof_Rachid_Adapter.ViewHolder> {

    List<Prof_Rachid> list;
    Context context;
    int res;

    public Prof_Rachid_Adapter(Context context, int item_layout, List<Prof_Rachid> list){
        this.list = list;
        this.res = item_layout;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(res, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nom.setText(list.get(position).getNom()+"");
        holder.specialite.setText(list.get(position).getSpecialite());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nom,specialite;
        CardView container;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nom = itemView.findViewById(R.id.nom);
            specialite = itemView.findViewById(R.id.specialite);
            container = itemView.findViewById(R.id.container);

        }

    }
}
