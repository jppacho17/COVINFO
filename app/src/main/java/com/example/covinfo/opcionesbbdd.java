package com.example.covinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class opcionesbbdd extends AppCompatActivity {

    Button btnAñadir;
    Button btnModificar;
    Button btnMostrar;
    Button btnEliminar;
    Button btnEnviar;
    Button btnGrafico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcionesbbdd);

        btnAñadir = (Button) findViewById(R.id.buttonAñadirDatos);
        btnMostrar  = (Button) findViewById(R.id.buttonMostrarDatos);
        btnEliminar  = (Button) findViewById(R.id.buttonEliminarDatos);

        btnAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(opcionesbbdd.this,AnadirDatosbbdd.class);
                startActivity(ir);
            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(opcionesbbdd.this,ObtenerDatosbbdd.class);
                startActivity(ir);
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(opcionesbbdd.this,EliminarDatosbbdd.class);
                startActivity(ir);
            }
        });

    }
}