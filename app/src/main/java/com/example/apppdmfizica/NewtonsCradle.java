package com.example.apppdmfizica;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NewtonsCradle extends AppCompatActivity {

    private NewtonsCradleView newtonsCradleView;
    private EditText numPendulumsInput;
    private EditText gravityInput;
    private EditText pendulumLengthInput;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newtons_cradle);

        newtonsCradleView = findViewById(R.id.newtonsCradleView);
        numPendulumsInput = findViewById(R.id.numPendulumsInput);
        gravityInput = findViewById(R.id.gravityInput);
        pendulumLengthInput = findViewById(R.id.pendulumLengthInput);
        startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(v -> {
            int numPendulums = parseIntOrDefault(numPendulumsInput.getText().toString(), 2);
            float gravity = parseFloatOrDefault(gravityInput.getText().toString(), 9.8f);
            float pendulumLength = parseFloatOrDefault(pendulumLengthInput.getText().toString(), 200f);

            newtonsCradleView.setNumPendulums(numPendulums);
            newtonsCradleView.setGravity(gravity);
            newtonsCradleView.setPendulumLength(pendulumLength);
            newtonsCradleView.startSimulation();
        });
    }

    private int parseIntOrDefault(String str, int defaultValue) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    private float parseFloatOrDefault(String str, float defaultValue) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
