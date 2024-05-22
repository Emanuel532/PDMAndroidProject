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
        Button buttonFormula5 = findViewById(R.id.button_formula5);
        Button buttonFormula6 = findViewById(R.id.button_formula6);
        Button buttonFormula7 = findViewById(R.id.button_formula7);
        Button buttonFormula8 = findViewById(R.id.button_formula8);
        Button buttonFormula9 = findViewById(R.id.button_formula9);
        Button buttonFormula10 = findViewById(R.id.button_formula10);
        Button buttonFormula11 = findViewById(R.id.button_formula11);

        TextView textView = findViewById(R.id.textView_rezultat);
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


        //acum butonul pentru MRUV
        buttonFormula2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Deschide un dialog pentru a solicita utilizatorului datele necesare
                AlertDialog.Builder builder = new AlertDialog.Builder(CalculatorActivity.this);
                builder.setTitle("Calcul mișcare rectilinie uniform variată");

                // Layout-ul pentru dialog
                LinearLayout layout = new LinearLayout(CalculatorActivity.this);
                layout.setOrientation(LinearLayout.VERTICAL);

                // Adaugă câmpuri de intrare pentru viteză inițială, viteză finală și timp
                final EditText editInitialVelocity = new EditText(CalculatorActivity.this);
                editInitialVelocity.setHint("Viteză inițială (m/s)");
                layout.addView(editInitialVelocity);

                final EditText editFinalVelocity = new EditText(CalculatorActivity.this);
                editFinalVelocity.setHint("Viteză finală (m/s)");
                layout.addView(editFinalVelocity);

                final EditText editTime = new EditText(CalculatorActivity.this);
                editTime.setHint("Timp (s)");
                layout.addView(editTime);

                builder.setView(layout);

                // Adaugă butonul "Calculare" în dialog
                builder.setPositiveButton("Calculare", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extrage valorile introduse de utilizator
                        double initialVelocity = Double.parseDouble(editInitialVelocity.getText().toString());
                        double finalVelocity = Double.parseDouble(editFinalVelocity.getText().toString());
                        double time = Double.parseDouble(editTime.getText().toString());

                        // Calculează accelerația
                        double acceleration = (finalVelocity - initialVelocity) / time;

                        // Afișează rezultatul în TextView
                        TextView textView = findViewById(R.id.textView_rezultat);
                        String userInput = "Viteză inițială: " + initialVelocity + " m/s\n" +
                                "Viteză finală: " + finalVelocity + " m/s\n" +
                                "Timp: " + time + " s\n";
                        String resultText = "Acceleratie: " + acceleration + " m/s^2";
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

        //buton calculat formula miscare ciruclara
        buttonFormula3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Deschide un dialog pentru a solicita utilizatorului datele necesare
                AlertDialog.Builder builder = new AlertDialog.Builder(CalculatorActivity.this);
                builder.setTitle("Calcul mișcare circulară");

                // Layout-ul pentru dialog
                LinearLayout layout = new LinearLayout(CalculatorActivity.this);
                layout.setOrientation(LinearLayout.VERTICAL);

                // Adaugă câmpuri de intrare pentru viteză unghiulară și rază
                final EditText editAngularVelocity = new EditText(CalculatorActivity.this);
                editAngularVelocity.setHint("Viteză unghiulară (rad/s)");
                layout.addView(editAngularVelocity);

                final EditText editRadius = new EditText(CalculatorActivity.this);
                editRadius.setHint("Rază (m)");
                layout.addView(editRadius);

                builder.setView(layout);

                // Adaugă butonul "Calculare" în dialog
                builder.setPositiveButton("Calculare", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extrage valorile introduse de utilizator
                        double angularVelocity = Double.parseDouble(editAngularVelocity.getText().toString());
                        double radius = Double.parseDouble(editRadius.getText().toString());

                        // Calculează viteza lineară
                        double linearVelocity = angularVelocity * radius;

                        // Afișează rezultatul în TextView
                        TextView textView = findViewById(R.id.textView_rezultat);
                        String userInput = "Viteză unghiulară: " + angularVelocity + " rad/s\n" +
                                "Rază: " + radius + " m\n";
                        String resultText = "Viteză lineară: " + linearVelocity + " m/s";
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

        //ENERGIA CINETICA
        buttonFormula4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Deschide un dialog pentru a solicita utilizatorului datele necesare
                AlertDialog.Builder builder = new AlertDialog.Builder(CalculatorActivity.this);
                builder.setTitle("Calcul energie cinetică");

                // Layout-ul pentru dialog
                LinearLayout layout = new LinearLayout(CalculatorActivity.this);
                layout.setOrientation(LinearLayout.VERTICAL);

                // Adaugă câmpuri de intrare pentru masa și viteza
                final EditText editMass = new EditText(CalculatorActivity.this);
                editMass.setHint("Masă (kg)");
                layout.addView(editMass);

                final EditText editVelocity = new EditText(CalculatorActivity.this);
                editVelocity.setHint("Viteză (m/s)");
                layout.addView(editVelocity);

                builder.setView(layout);

                // Adaugă butonul "Calculare" în dialog
                builder.setPositiveButton("Calculare", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extrage valorile introduse de utilizator
                        double mass = Double.parseDouble(editMass.getText().toString());
                        double velocity = Double.parseDouble(editVelocity.getText().toString());

                        // Calculează energia cinetică
                        double kineticEnergy = 0.5 * mass * velocity * velocity;

                        // Afișează rezultatul în TextView
                        TextView textView = findViewById(R.id.textView_rezultat);
                        String userInput = "Masă: " + mass + " kg\n" +
                                "Viteză: " + velocity + " m/s\n";
                        String resultText = "Energie cinetică: " + kineticEnergy + " J";
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


// Buton pentru Legea lui Hooke
        buttonFormula5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Deschide un dialog pentru a solicita utilizatorului datele necesare
                AlertDialog.Builder builder = new AlertDialog.Builder(CalculatorActivity.this);
                builder.setTitle("Calcul Legea lui Hooke");

                // Layout-ul pentru dialog
                LinearLayout layout = new LinearLayout(CalculatorActivity.this);
                layout.setOrientation(LinearLayout.VERTICAL);

                // Adaugă câmpuri de intrare pentru constanta elastică și deformație
                final EditText editSpringConstant = new EditText(CalculatorActivity.this);
                editSpringConstant.setHint("Constanta elastică (N/m)");
                layout.addView(editSpringConstant);

                final EditText editDeformation = new EditText(CalculatorActivity.this);
                editDeformation.setHint("Deformație (m)");
                layout.addView(editDeformation);

                builder.setView(layout);

                // Adaugă butonul "Calculare" în dialog
                builder.setPositiveButton("Calculare", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extrage valorile introduse de utilizator
                        double springConstant = Double.parseDouble(editSpringConstant.getText().toString());
                        double deformation = Double.parseDouble(editDeformation.getText().toString());

                        // Calculează forța folosind Legea lui Hooke
                        double force = springConstant * deformation;

                        // Afișează rezultatul în TextView
                        TextView textView = findViewById(R.id.textView_rezultat);
                        String userInput = "Constanta elastică: " + springConstant + " N/m\n" +
                                "Deformație: " + deformation + " m\n";
                        String resultText = "Forța: " + force + " N";
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

// Buton pentru Legea I a termodinamicii
        buttonFormula6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Deschide un dialog pentru a explica Legea I a termodinamicii
                AlertDialog.Builder builder = new AlertDialog.Builder(CalculatorActivity.this);
                builder.setTitle("Legea I a termodinamicii");

                TextView textView = findViewById(R.id.textView_rezultat);
                String resultText = "Energia totală a unui sistem izolat rămâne constantă.";
                textView.setText(resultText);
            }
        });

// Buton pentru Legea a II-a a termodinamicii
        buttonFormula7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Deschide un dialog pentru a explica Legea a II-a a termodinamicii
                AlertDialog.Builder builder = new AlertDialog.Builder(CalculatorActivity.this);
                builder.setTitle("Legea a II-a a termodinamicii");

                TextView textView = findViewById(R.id.textView_rezultat);
                String resultText = "Entropia unui sistem izolat tinde să crească în timp.";
                textView.setText(resultText);
            }
        });

// Buton pentru Ecuația gazului ideal
        buttonFormula8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Deschide un dialog pentru a solicita utilizatorului datele necesare
                AlertDialog.Builder builder = new AlertDialog.Builder(CalculatorActivity.this);
                builder.setTitle("Calcul Ecuația gazului ideal");

                // Layout-ul pentru dialog
                LinearLayout layout = new LinearLayout(CalculatorActivity.this);
                layout.setOrientation(LinearLayout.VERTICAL);

                // Adaugă câmpuri de intrare pentru presiune, volum, cantitatea de substanță și temperatura
                final EditText editPressure = new EditText(CalculatorActivity.this);
                editPressure.setHint("Presiune (Pa)");
                layout.addView(editPressure);

                final EditText editVolume = new EditText(CalculatorActivity.this);
                editVolume.setHint("Volum (m³)");
                layout.addView(editVolume);

                final EditText editMoles = new EditText(CalculatorActivity.this);
                editMoles.setHint("Cantitatea de substanță (mol)");
                layout.addView(editMoles);

                final EditText editTemperature = new EditText(CalculatorActivity.this);
                editTemperature.setHint("Temperatură (K)");
                layout.addView(editTemperature);

                builder.setView(layout);

                // Adaugă butonul "Calculare" în dialog
                builder.setPositiveButton("Calculare", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extrage valorile introduse de utilizator
                        double pressure = Double.parseDouble(editPressure.getText().toString());
                        double volume = Double.parseDouble(editVolume.getText().toString());
                        double moles = Double.parseDouble(editMoles.getText().toString());
                        double temperature = Double.parseDouble(editTemperature.getText().toString());

                        // Constanta universala a gazului R
                        double R = 8.314;

                        // Calculează oricare dintre variabile folosind Ecuația gazului ideal PV = nRT
                        double idealGasEquation = (pressure * volume) / (moles * R * temperature);

                        // Afișează rezultatul în TextView


                        String userInput = "Presiune: " + pressure + " Pa\n" +
                                "Volum: " + volume + " m³\n" +
                                "Cantitatea de substanță: " + moles + " mol\n" +
                                "Temperatură: " + temperature + " K\n";
                        String resultText = "Ecuația gazului ideal: " + idealGasEquation;
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

// Buton pentru Legea lui Ohm
        buttonFormula9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Deschide un dialog pentru a solicita utilizatorului datele necesare
                AlertDialog.Builder builder = new AlertDialog.Builder(CalculatorActivity.this);
                builder.setTitle("Calcul Legea lui Ohm");

                // Layout-ul pentru dialog
                LinearLayout layout = new LinearLayout(CalculatorActivity.this);
                layout.setOrientation(LinearLayout.VERTICAL);

                // Adaugă câmpuri de intrare pentru tensiune și rezistență
                final EditText editVoltage = new EditText(CalculatorActivity.this);
                editVoltage.setHint("Tensiune (V)");
                layout.addView(editVoltage);

                final EditText editResistance = new EditText(CalculatorActivity.this);
                editResistance.setHint("Rezistență (Ω)");
                layout.addView(editResistance);

                builder.setView(layout);

                // Adaugă butonul "Calculare" în dialog
                builder.setPositiveButton("Calculare", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extrage valorile introduse de utilizator
                        double voltage = Double.parseDouble(editVoltage.getText().toString());
                        double resistance = Double.parseDouble(editResistance.getText().toString());

                        // Calculează curentul folosind Legea lui Ohm
                        double current = voltage / resistance;

                        // Afișează rezultatul în TextView
                        TextView textView = findViewById(R.id.textView_rezultat);
                        String userInput = "Tensiune: " + voltage + " V\n" +
                                "Rezistență: " + resistance + " Ω\n";
                        String resultText = "Curent: " + current + " A";
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

// Buton pentru Legea reflexiei
        buttonFormula10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Deschide un dialog pentru a explica Legea reflexiei
                AlertDialog.Builder builder = new AlertDialog.Builder(CalculatorActivity.this);
                builder.setTitle("Legea reflexiei");

                TextView textView = findViewById(R.id.textView_rezultat);
                String resultText = "Unghiul de incidență este egal cu unghiul de reflexie.";
                textView.setText(resultText);
            }
        });

// Buton pentru Legea refracției
        buttonFormula11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Deschide un dialog pentru a solicita utilizatorului datele necesare
                AlertDialog.Builder builder = new AlertDialog.Builder(CalculatorActivity.this);
                builder.setTitle("Calcul Legea refracției");

                // Layout-ul pentru dialog
                LinearLayout layout = new LinearLayout(CalculatorActivity.this);
                layout.setOrientation(LinearLayout.VERTICAL);

                // Adaugă câmpuri de intrare pentru indicele de refracție și unghiurile de incidență și de refracție
                final EditText editRefractiveIndex1 = new EditText(CalculatorActivity.this);
                editRefractiveIndex1.setHint("Indicele de refracție al mediului 1");
                layout.addView(editRefractiveIndex1);

                final EditText editRefractiveIndex2 = new EditText(CalculatorActivity.this);
                editRefractiveIndex2.setHint("Indicele de refracție al mediului 2");
                layout.addView(editRefractiveIndex2);

                final EditText editAngleIncidence = new EditText(CalculatorActivity.this);
                editAngleIncidence.setHint("Unghiul de incidență (grade)");
                layout.addView(editAngleIncidence);

                builder.setView(layout);

                // Adaugă butonul "Calculare" în dialog
                builder.setPositiveButton("Calculare", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extrage valorile introduse de utilizator
                        double refractiveIndex1 = Double.parseDouble(editRefractiveIndex1.getText().toString());
                        double refractiveIndex2 = Double.parseDouble(editRefractiveIndex2.getText().toString());
                        double angleIncidence = Double.parseDouble(editAngleIncidence.getText().toString());

                        // Calculează unghiul de refracție folosind Legea refracției (Legea lui Snell)
                        double angleIncidenceRad = Math.toRadians(angleIncidence);
                        double angleRefractionRad = Math.asin((refractiveIndex1 / refractiveIndex2) * Math.sin(angleIncidenceRad));
                        double angleRefraction = Math.toDegrees(angleRefractionRad);

                        // Afișează rezultatul în TextView
                        TextView textView = findViewById(R.id.textView_rezultat);
                        String userInput = "Indicele de refracție al mediului 1: " + refractiveIndex1 + "\n" +
                                "Indicele de refracție al mediului 2: " + refractiveIndex2 + "\n" +
                                "Unghiul de incidență: " + angleIncidence + "°\n";
                        String resultText = "Unghiul de refracție: " + angleRefraction + "°";
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

    }
}
