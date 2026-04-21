package com.enset.atelier2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReclamationAdapter extends RecyclerView.Adapter<ReclamationAdapter.ViewHolder> {

    private ArrayList<Reclamation> listeReclamations;

    public ReclamationAdapter(ArrayList<Reclamation> listeReclamations) {
        this.listeReclamations = listeReclamations;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitre, txtDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            txtTitre       = itemView.findViewById(R.id.txtTitre);
            txtDescription = itemView.findViewById(R.id.txtDescription);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vue = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_reclamation, parent, false);
        return new ViewHolder(vue);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Reclamation reclamation = listeReclamations.get(position);
        holder.txtTitre.setText(reclamation.getTitre());
        holder.txtDescription.setText(reclamation.getDescription());
    }

    @Override
    public int getItemCount() { return listeReclamations.size(); }
}