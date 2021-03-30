package com.example.covinfo;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageButton;

public class menubbddfinal extends AppCompatActivity {

    ImageButton btnDatos;
    ImageButton btnGraficas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menubbddfinal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab3 = findViewById(R.id.fab3);
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ir = new Intent(menubbddfinal.this,MostrarUsuarios.class);
                startActivity(ir);
            }
        });

        FloatingActionButton fab4 = findViewById(R.id.fab4);
        fab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ir = new Intent(menubbddfinal.this,MostrarDatosMedico.class);
                startActivity(ir);
            }
        });

        ImageButton btnDatos= (ImageButton) findViewById(R.id.imgbtndatos);
        ImageButton btnGraficas= (ImageButton) findViewById(R.id.imgbtngraficas);

        btnDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(menubbddfinal.this,mostrarDatosUsuario.class);
                startActivity(ir);
            }
        });

        btnGraficas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(menubbddfinal.this,graficaTemperaturas.class);
                startActivity(ir);
            }
        });


    }
}