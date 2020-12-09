package com.example.covinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Opciones extends AppCompatActivity {

    Button btnEstadisticas;
    Button btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);

        btnEstadisticas = (Button) findViewById(R.id.buttonEstadisticas);
        btnTest = (Button) findViewById(R.id.buttonTest);

        btnEstadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irWeb = new Intent(Opciones.this,import_web.class);
                startActivity(irWeb);
            }
        });

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irTest = new Intent(Opciones.this,test_covid_inicio.class);
                startActivity(irTest);
            }
        });
    }
}