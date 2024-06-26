package com.example.apppdmfizica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VizualizatorList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vizualizator_list);

        Button buttonLaunchPendulum = findViewById(R.id.button_pendul);
        buttonLaunchPendulum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VizualizatorList.this, PendulumActivity.class);
                startActivity(intent);
            }
        });

        Button buttonLaunchPlanInclinat = findViewById(R.id.buton_plan_inclinat);
        buttonLaunchPlanInclinat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VizualizatorList.this, SlopeSimulatorActivity.class);
                startActivity(intent);
            }
        });

        Button buttonLaunchArc = findViewById(R.id.button_arc);
        buttonLaunchArc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VizualizatorList.this, SpringSimulatorActivity.class);
                startActivity(intent);
            }
        });

        Button buttonProiectil = findViewById(R.id.button_formula_proiectil);
        buttonProiectil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VizualizatorList.this, ProjectileSimulatorActivity.class);
                startActivity(intent);
            }
        });

        Button butonNewtonCradles = findViewById(R.id.butonNewtonCradles);
        butonNewtonCradles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VizualizatorList.this, NewtonsCradle.class);
                startActivity(intent);
            }
        });
    }


}