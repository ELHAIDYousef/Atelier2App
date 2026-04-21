package com.enset.atelier2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReclamationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reclamation);

        EditText edtTitre       = findViewById(R.id.edtTitre);
        EditText edtDescription = findViewById(R.id.edtDescription);
        Button   btnAjouter     = findViewById(R.id.btnAjouter);
        RecyclerView recyclerView = findViewById(R.id.recyclerReclamations);

        // Données initiales
        ArrayList<Reclamation> listeReclamations = new ArrayList<>();
        listeReclamations.add(new Reclamation("Nettoyage parking",     "Sous-sol"));
        listeReclamations.add(new Reclamation("Fuite d'eau",           "Appartement 12"));
        listeReclamations.add(new Reclamation("Ascenseur en panne",    "Bloc B"));
        listeReclamations.add(new Reclamation("Problème d'éclairage",  "Couloir 2"));
        listeReclamations.add(new Reclamation("Porte cassée",          "Entrée principale"));
        listeReclamations.add(new Reclamation("Caméra non fonctionnelle", "Parking"));

        ReclamationAdapter adapter = new ReclamationAdapter(listeReclamations);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btnAjouter.setOnClickListener(v -> {
            String titre       = edtTitre.getText().toString();
            String description = edtDescription.getText().toString();

            if (titre.isEmpty() || description.isEmpty()) {
                Toast.makeText(this,
                        "Veuillez remplir tous les champs",
                        Toast.LENGTH_SHORT).show();
            } else {
                listeReclamations.add(new Reclamation(titre, description));
                adapter.notifyDataSetChanged();
                edtTitre.setText("");
                edtDescription.setText("");
                Toast.makeText(this,
                        "Réclamation ajoutée",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}