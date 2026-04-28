package com.enset.atelier2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReclamationAdapter extends RecyclerView.Adapter<ReclamationAdapter.ViewHolder> {

    private ArrayList<Reclamation> listeReclamations;
    private OnItemActionListener  listener;

    // Interface pour communiquer les clics vers l'Activity
    public interface OnItemActionListener {
        void onModifier(Reclamation reclamation, int position);
        void onSupprimer(Reclamation reclamation, int position);
    }

    public ReclamationAdapter(ArrayList<Reclamation> listeReclamations,
                              OnItemActionListener listener) {
        this.listeReclamations = listeReclamations;
        this.listener          = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView    txtTitre, txtDescription;
        ImageButton btnModifier, btnSupprimer;

        public ViewHolder(View itemView) {
            super(itemView);
            txtTitre       = itemView.findViewById(R.id.txtTitre);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            btnModifier    = itemView.findViewById(R.id.btnModifier);
            btnSupprimer   = itemView.findViewById(R.id.btnSupprimer);
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

        holder.btnModifier.setOnClickListener(v -> {
            if (listener != null)
                listener.onModifier(reclamation, holder.getAdapterPosition());
        });

        holder.btnSupprimer.setOnClickListener(v -> {
            if (listener != null)
                listener.onSupprimer(reclamation, holder.getAdapterPosition());
        });
    }

    @Override
    public int getItemCount() { return listeReclamations.size(); }
}