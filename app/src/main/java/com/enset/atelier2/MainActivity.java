package com.enset.atelier2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnContinuer = findViewById(R.id.btnContinuer);
        btnContinuer.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, activity_dashboard.class);
            startActivity(intent);
        });
    }
}