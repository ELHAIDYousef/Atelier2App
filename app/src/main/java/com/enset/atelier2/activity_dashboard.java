package com.enset.atelier2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class activity_dashboard extends AppCompatActivity {

    private TextView txtSelected;
    private CardView lastSelected = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        txtSelected = findViewById(R.id.txtSelected);

        CardView cardSolde       = findViewById(R.id.cardSolde);
        CardView cardTravaux     = findViewById(R.id.cardTravaux);
        CardView cardReclamation = findViewById(R.id.cardReclamation);
        CardView cardProximite   = findViewById(R.id.cardProximite);

        cardSolde.setOnClickListener(v ->
                showSelected(cardSolde, "Solde de trésorerie"));

        cardTravaux.setOnClickListener(v ->
                showSelected(cardTravaux, "Travaux en cours"));

        cardReclamation.setOnClickListener(v -> {
            Intent intent = new Intent(activity_dashboard.this, ReclamationActivity.class);
            startActivity(intent);
        });

        cardProximite.setOnClickListener(v ->
                showSelected(cardProximite, "À proximité"));
    }

    private void showSelected(CardView clicked, String label) {
        // Si on reclique la même carte → masquer le label (toggle)
        if (lastSelected == clicked) {
            txtSelected.setVisibility(View.GONE);
            lastSelected = null;
            return;
        }
        // Sinon afficher le nouveau label et mémoriser la carte
        txtSelected.setText(label);
        txtSelected.setVisibility(View.VISIBLE);
        lastSelected = clicked;
    }
}