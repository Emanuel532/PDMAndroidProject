package com.example.apppdmfizica;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class PendulumActivity extends AppCompatActivity {

    private PendulumView pendulumView;
    private EditText editLength, editGravity, editBobRadius;
    private CheckBox checkboxAirResistance;
    private Button buttonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendulum);

        pendulumView = findViewById(R.id.pendulumView);
        editLength = findViewById(R.id.editLength);
        editGravity = findViewById(R.id.editGravity);
        editBobRadius = findViewById(R.id.editBobRadius);
        checkboxAirResistance = findViewById(R.id.checkboxAirResistance);
        buttonReset = findViewById(R.id.buttonReset);

        buttonReset.setOnClickListener(v -> {
            float length = getInputValue(editLength, 400);
            float gravity = getInputValue(editGravity, 9.8f);
            float bobRadius = getInputValue(editBobRadius, 40);
            boolean airResistanceEnabled = !checkboxAirResistance.isChecked();

            pendulumView.setLength(length);
            pendulumView.setGravity(gravity);
            pendulumView.setBobRadius(bobRadius);
            pendulumView.setAirResistanceEnabled(airResistanceEnabled);
            pendulumView.resetPendulum();
        });
    }

    private float getInputValue(EditText editText, float defaultValue) {
        String input = editText.getText().toString();
        if (!TextUtils.isEmpty(input)) {
            try {
                return Float.parseFloat(input);
            } catch (NumberFormatException e) {
            }
        }
        return defaultValue;
    }
}
