package com.enset.atelier2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btnContinuer);

        btn.setOnClickListener(view -> {
            Toast.makeText(this,
                    "Bienvenue dans l'application de gestion de syndic",
                    Toast.LENGTH_SHORT).show();
        });
    }
}