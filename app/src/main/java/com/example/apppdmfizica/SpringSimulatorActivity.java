package com.example.apppdmfizica;


import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class SpringSimulatorActivity extends AppCompatActivity {

    private SpringView springView;
    private EditText editSpringConstant, editDampingFactor, editMass, editInitialDisplacement;
    private Button buttonStartSimulation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spring_simulator);

        springView = findViewById(R.id.springView);
        editSpringConstant = findViewById(R.id.editSpringConstant);
        editDampingFactor = findViewById(R.id.editDampingFactor);
        editMass = findViewById(R.id.editMass);
        editInitialDisplacement = findViewById(R.id.editInitialDisplacement);
        buttonStartSimulation = findViewById(R.id.buttonStartSimulation);

        buttonStartSimulation.setOnClickListener(v -> {
            float springConstant = getInputValue(editSpringConstant, 10.0f);
            float dampingFactor = getInputValue(editDampingFactor, 0.1f);
            float mass = getInputValue(editMass, 1.0f);
            float initialDisplacement = getInputValue(editInitialDisplacement, 200.0f);

            springView.setSpringConstant(springConstant);
            springView.setDampingFactor(dampingFactor);
            springView.setMass(mass);
            springView.setInitialDisplacement(initialDisplacement);
            springView.startSimulation();
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
