package com.example.covinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class menuprincipalfinal extends AppCompatActivity {

    ImageButton btngestion,btntest,btnestadisticasmun,btnrecomendaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprincipalfinal);

        ImageButton btngestion= (ImageButton) findViewById(R.id.imgbtngestiondatos);
        ImageButton btntest= (ImageButton) findViewById(R.id.imgbtntest);
        ImageButton btnestadisticasmun= (ImageButton) findViewById(R.id.imgbtnEstadMundiales);
        ImageButton btnrecomendaciones= (ImageButton) findViewById(R.id.imgbtnrecomendaciones);

        btngestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(menuprincipalfinal.this,menubbddfinal.class);
                startActivity(ir);
            }
        });

        btntest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(menuprincipalfinal.this,test_covid_inicio.class);
                startActivity(ir);
            }
        });

        btnestadisticasmun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(menuprincipalfinal.this,import_web.class);
                startActivity(ir);
            }
        });

        btnrecomendaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent ir = new Intent(menuprincipalfinal.this,menubbddfinal.class);
                //startActivity(ir);
            }
        });
    }
}