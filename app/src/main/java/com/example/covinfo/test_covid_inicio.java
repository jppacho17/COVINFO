package com.example.covinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class test_covid_inicio extends AppCompatActivity {

    Button btnComenzar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_covid_inicio);

        btnComenzar = (Button) findViewById(R.id.buttonTestInicio);

        btnComenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent comenzarTest = new Intent(test_covid_inicio.this,test_covid_P1.class);
                startActivity(comenzarTest);
            }
        });
    }
}