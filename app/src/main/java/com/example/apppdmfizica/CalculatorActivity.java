package com.example.apppdmfizica;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        // Leagă butoanele din layout
        Button buttonFormula1 = findViewById(R.id.button_formula1);
        Button buttonFormula2 = findViewById(R.id.button_formula2);
        Button buttonFormula3 = findViewById(R.id.button_formula3);
        Button buttonFormula4 = findViewById(R.id.button_formula4);
        // Adaugă aici butoanele pentru alte formule

        // Setează ascultători pentru butoanele de formule
        buttonFormula1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Deschide un dialog pentru a solicita utilizatorului datele necesare
                AlertDialog.Builder builder = new AlertDialog.Builder(CalculatorActivity.this);
                builder.setTitle("Calcul mișcare rectilinie uniformă");

                // Layout-ul pentru dialog
                LinearLayout layout = new LinearLayout(CalculatorActivity.this);
                layout.setOrientation(LinearLayout.VERTICAL);

                // Adaugă câmpuri de intrare pentru viteză și timp
                final EditText editVelocity = new EditText(CalculatorActivity.this);
                editVelocity.setHint("Viteză (m/s)");
                layout.addView(editVelocity);

                final EditText editTime = new EditText(CalculatorActivity.this);
                editTime.setHint("Timp (s)");
                layout.addView(editTime);

                builder.setView(layout);

                // Adaugă butonul "Calculare" în dialog
                builder.setPositiveButton("Calculare", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extrage valorile introduse de utilizator
                        double velocity = Double.parseDouble(editVelocity.getText().toString());
                        double time = Double.parseDouble(editTime.getText().toString());

                        // Calculează poziția
                        double position = velocity * time;

                        // Afișează rezultatul în TextView
                        TextView textView = findViewById(R.id.textView_rezultat);
                        String userInput = "Viteză: " + velocity + " m/s\nTimp: " + time + " s\n";
                        String resultText = "Rezulatul calculului: " + position + " metri";
                        textView.setText(userInput + resultText);
                    }
                });

                // Adaugă butonul "Anulare" în dialog
                builder.setNegativeButton("Anulare", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                // Afișează dialogul
                builder.show();
            }
        });

        buttonFormula2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implementează acțiunea corespunzătoare formulei 2
                // Schimbă fragmentul sau efectuează altă acțiune
            }
        });
        buttonFormula3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implementează acțiunea corespunzătoare formulei 1
                // Schimbă fragmentul sau efectuează altă acțiune
            }
        });

        buttonFormula4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implementează acțiunea corespunzătoare formulei 2
                // Schimbă fragmentul sau efectuează altă acțiune
            }
        });

    }
}
