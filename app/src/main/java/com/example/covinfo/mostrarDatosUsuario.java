package com.example.covinfo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class mostrarDatosUsuario extends AppCompatActivity {

    private TextView txtResultado;
    private Button btnVolver;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos_usuario);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        FloatingActionButton fab2 = findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "En el futuro se enviarán los datos", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        txtResultado = (TextView) findViewById(R.id.datosUsuario);
        //btnVolver = (Button) findViewById(R.id.selectVolver);


        // BD
        Developerbbdd BaseDatos = new Developerbbdd(this);
        db = BaseDatos.getReadableDatabase();

        // Alternativa: query
        String[] campos = new String[] { "dni","temperatura","fecha","sint1", "sint2","otros"};
        //Invocación método para obtener todas las columnas de la base de datos, sin condiciones
        Cursor c = db.query("DATOS", campos, null, null, null, null, null);
        while(c.moveToNext()){
            String dni = c.getString(0);
            String temperatura = c.getString(1);
            String fecha = c.getString(2);
            String sint1 = c.getString(3);
            String sint2 = c.getString(4);
            String otros = c.getString(5);
            txtResultado.append(dni + " - " + temperatura + " - " + fecha + " - " + sint1 + " "  + sint2 + "" + otros + "" +"\n");
        }

    }
}