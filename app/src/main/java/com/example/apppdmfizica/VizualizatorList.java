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
    }


}