package com.example.apppdmfizica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private ImageView logoImageView;
    private TextView titleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logoImageView = findViewById(R.id.logoImageView);
        titleTextView = findViewById(R.id.titleTextView);
        //animatie titlu si imagine
        startAnimation();


        //PENTRU VIZIUALIZARE PENDUL
        Button buttonLaunchPendulum = findViewById(R.id.button_vizualizator);
        buttonLaunchPendulum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PendulumActivity.class);
                startActivity(intent);
            }
        });


        Button buttonExplicatii = findViewById(R.id.button_explicatii);
        buttonExplicatii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ExplicatiiActivity.class);
                startActivity(intent);
            }
        });

        Button buttonCalculator = findViewById(R.id.button_calculator);
        buttonCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
                startActivity(intent);
            }
        });

        //button ajutor
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start HelpActivity
                startActivity(new Intent(MainActivity.this, HelpActivity.class));
            }
        });
    }

    private void startAnimation() {
        // Logo app animatie
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        logoImageView.setVisibility(View.VISIBLE);
        logoImageView.startAnimation(fadeIn);

        // Animatie titlu app
        Animation fadeIn2 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        titleTextView.setVisibility(View.VISIBLE);
        titleTextView.startAnimation(fadeIn2);
    }
}