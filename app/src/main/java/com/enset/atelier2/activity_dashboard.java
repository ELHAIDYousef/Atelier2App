package com.enset.atelier2;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class activity_dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        CardView cardSolde = findViewById(R.id.cardSolde);
        cardSolde.setOnClickListener(v ->
                Toast.makeText(this, "Solde de trésorerie", Toast.LENGTH_SHORT).show());

        CardView cardTravaux = findViewById(R.id.cardTravaux);
        cardTravaux.setOnClickListener(v ->
                Toast.makeText(this, "Travaux en cours", Toast.LENGTH_SHORT).show());

        CardView cardReclamation = findViewById(R.id.cardReclamation);
        cardReclamation.setOnClickListener(v ->
                Toast.makeText(this, "Réclamation", Toast.LENGTH_SHORT).show());

        CardView cardProximite = findViewById(R.id.cardProximite);
        cardProximite.setOnClickListener(v ->
                Toast.makeText(this, "À proximité", Toast.LENGTH_SHORT).show());
    }
}