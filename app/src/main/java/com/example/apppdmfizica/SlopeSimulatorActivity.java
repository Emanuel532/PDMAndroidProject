package com.example.apppdmfizica;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class SlopeSimulatorActivity extends AppCompatActivity {

    private SlopeView slopeView;
    private EditText editInitialVelocity, editWeight, editGravity;
    private CheckBox checkBoxAirResistance;
    private Button buttonStartSimulation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slope_simulator);

        slopeView = findViewById(R.id.slopeView);
        editInitialVelocity = findViewById(R.id.editInitialVelocity);
        checkBoxAirResistance = findViewById(R.id.checkBoxAirResistance);
        buttonStartSimulation = findViewById(R.id.buttonStartSimulation);

        buttonStartSimulation.setOnClickListener(v -> {
            float initialVelocity = getInputValue(editInitialVelocity, 5.0f);
            float weight = 1.0f;
            float gravity = 9.8f;
            boolean airResistance = checkBoxAirResistance.isChecked();

            slopeView.setInitialVelocity(initialVelocity);
            slopeView.setWeight(weight);
            slopeView.setGravity(gravity);
            slopeView.resetSimulation();
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
