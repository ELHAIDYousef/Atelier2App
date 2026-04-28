package com.enset.atelier2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;

public class ReclamationActivity extends AppCompatActivity
        implements ReclamationAdapter.OnItemActionListener {

    private EditText             edtTitre, edtDescription;
    private Button               btnAjouter;
    private RecyclerView         recyclerView;
    private ReclamationAdapter   adapter;
    private ArrayList<Reclamation> listeReclamations;
    private AppDatabase          db;

    private Reclamation reclamationEnEdition = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reclamation);

        // Vues
        edtTitre       = findViewById(R.id.edtTitre);
        edtDescription = findViewById(R.id.edtDescription);
        btnAjouter     = findViewById(R.id.btnAjouter);
        recyclerView   = findViewById(R.id.recyclerReclamations);

        // Initialisation Room
        db = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class,
                "syndic_db"
        ).allowMainThreadQueries().build();

        // Charger les données depuis la base
        listeReclamations = new ArrayList<>(db.reclamationDao().getAll());

        // Adapter
        adapter = new ReclamationAdapter(listeReclamations, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Bouton Ajouter / Modifier
        btnAjouter.setOnClickListener(v -> {
            String titre       = edtTitre.getText().toString().trim();
            String description = edtDescription.getText().toString().trim();

            if (titre.isEmpty() || description.isEmpty()) {
                Toast.makeText(this,
                        "Veuillez remplir tous les champs",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            if (reclamationEnEdition == null) {
                // ── MODE AJOUT ──
                Reclamation nouvelle = new Reclamation(titre, description);
                db.reclamationDao().ajouter(nouvelle);
                Toast.makeText(this, "Réclamation ajoutée", Toast.LENGTH_SHORT).show();
            } else {
                // ── MODE MODIFICATION ──
                reclamationEnEdition.setTitre(titre);
                reclamationEnEdition.setDescription(description);
                db.reclamationDao().modifier(reclamationEnEdition);
                reclamationEnEdition = null;
                btnAjouter.setText("Ajouter la réclamation");
                Toast.makeText(this, "Réclamation modifiée", Toast.LENGTH_SHORT).show();
            }

            // Recharger la liste
            rafraichirListe();
            edtTitre.setText("");
            edtDescription.setText("");
        });
    }

    @Override
    public void onModifier(Reclamation reclamation, int position) {
        reclamationEnEdition = reclamation;
        edtTitre.setText(reclamation.getTitre());
        edtDescription.setText(reclamation.getDescription());
        btnAjouter.setText("Modifier la réclamation");
        // Faire défiler vers le formulaire
        recyclerView.smoothScrollToPosition(0);
    }

    @Override
    public void onSupprimer(Reclamation reclamation, int position) {
        db.reclamationDao().supprimer(reclamation);
        rafraichirListe();
        Toast.makeText(this, "Réclamation supprimée", Toast.LENGTH_SHORT).show();
    }

    private void rafraichirListe() {
        listeReclamations.clear();
        listeReclamations.addAll(db.reclamationDao().getAll());
        adapter.notifyDataSetChanged();
    }
}