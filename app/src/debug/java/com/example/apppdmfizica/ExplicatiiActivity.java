package com.example.apppdmfizica;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class ExplicatiiActivity extends AppCompatActivity {

    private ScrollView scrollViewExplicatii;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicatii);

        final ScrollView scrollViewContent = findViewById(R.id.scroll_view_content);
        Button buttonDropdown = findViewById(R.id.button_dropdown_MRU);

        buttonDropdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle visibility of ScrollView
                if (scrollViewContent.getVisibility() == View.VISIBLE) {
                    scrollViewContent.setVisibility(View.GONE);
                } else {
                    scrollViewContent.setVisibility(View.VISIBLE);
                }
            }
        });


        Button buttonDropdown2 = findViewById(R.id.button_dropdown_MRUV);
        final ScrollView scrollViewContent_MRUV = findViewById(R.id.scroll_view_content_MRUV);
        final ScrollView scrollViewContent_MC = findViewById(R.id.scroll_view_content_MC);

        buttonDropdown2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleScrollViewVisibility(scrollViewContent_MRUV);
                if (scrollViewContent != null) {
                    scrollViewContent.setVisibility(View.GONE);
                }

                if (scrollViewContent_MC != null) {
                    scrollViewContent_MC.setVisibility(View.GONE);
                }

                if (scrollViewExplicatii != null) {
                    scrollViewExplicatii.setVisibility(View.GONE);
                }
            }
        });

        Button buttonDropdown3 = findViewById(R.id.button_dropdown_MC);
        buttonDropdown3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleScrollViewVisibility(scrollViewContent_MC);
                if (scrollViewContent != null) {
                    scrollViewContent.setVisibility(View.GONE);
                }

                if (scrollViewContent_MRUV != null) {
                    scrollViewContent_MRUV.setVisibility(View.GONE);
                }

                if (scrollViewExplicatii != null) {
                    scrollViewExplicatii.setVisibility(View.GONE);
                }
            }


        });


    }

    private void toggleScrollViewVisibility(ScrollView scrollView) {
        if (scrollView.getVisibility() == View.VISIBLE) {
            scrollView.setVisibility(View.GONE);
        } else {
            scrollView.setVisibility(View.VISIBLE);
        }
    }
}

