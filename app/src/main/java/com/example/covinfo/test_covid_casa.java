package com.example.covinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class test_covid_casa extends AppCompatActivity {

    Button btnRepetirTest;
    Button btnMenuPrincipal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_covid_casa);

        btnRepetirTest = (Button) findViewById(R.id.buttonRepetirTest);
        btnMenuPrincipal = (Button) findViewById(R.id.buttonMenuPrincipal);

        btnRepetirTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repetir = new Intent(test_covid_casa.this,test_covid_inicio.class);
                startActivity(repetir);
            }
        });

        btnMenuPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irMenu = new Intent(test_covid_casa.this,menuprincipalfinal.class);
                startActivity(irMenu);
            }
        });
    }
}