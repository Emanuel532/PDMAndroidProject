package com.example.apppdmfizica;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class ProjectileSimulatorActivity extends AppCompatActivity {

    private ProjectileView projectileView;
    private EditText editWeight, editAngle, editGravity;
    private Button buttonStartSimulation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projectile_simulator);

        projectileView = findViewById(R.id.projectileView);
        editWeight = findViewById(R.id.editWeight);
        editAngle = findViewById(R.id.editAngle);
        editGravity = findViewById(R.id.editGravity);
        buttonStartSimulation = findViewById(R.id.buttonStartSimulation);

        buttonStartSimulation.setOnClickListener(v -> {
            float weight = getInputValue(editWeight, 1.0f);
            float angle = getInputValue(editAngle, 45.0f);
            float gravity = getInputValue(editGravity, 9.8f);

            projectileView.setWeight(weight);
            projectileView.setAngle(angle);
            projectileView.setGravity(gravity*10);
            projectileView.startSimulation();
        });
    }

    private float getInputValue(EditText editText, float defaultValue) {
        String input = editText.getText().toString();
        if (!TextUtils.isEmpty(input)) {
            try {
                return Float.parseFloat(input);
            } catch (NumberFormatException e) {
                // Handle invalid input
            }
        }
        return defaultValue;
    }
}
