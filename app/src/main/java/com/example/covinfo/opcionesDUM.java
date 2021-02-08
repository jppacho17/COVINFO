package com.example.covinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class opcionesDUM extends AppCompatActivity {

    Button btnDatos;
    Button btnUsuarios;
    Button btnCentroMedico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones_d_u_m);

        btnDatos = (Button) findViewById(R.id.btndatos);
        btnUsuarios  = (Button) findViewById(R.id.btnusuarios);
        btnCentroMedico  = (Button) findViewById(R.id.btncentroMedico);


        btnDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(opcionesDUM.this,mostrarDatosUsuario.class);
                startActivity(ir);
            }
        });

        btnUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent ir = new Intent(opcionesDUM.this,ObtenerDatosbbdd.class);
                //startActivity(ir);
            }
        });

        btnCentroMedico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent ir = new Intent(opcionesDUM.this,EliminarDatosbbdd.class);
                //startActivity(ir);
            }
        });



    }
}