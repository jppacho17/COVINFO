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
    private Button btnBuscar;
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
                Intent ir = new Intent(mostrarDatosUsuario.this,AnadirDatosUsuario.class);
                startActivity(ir);
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
        btnBuscar = (Button) findViewById(R.id.btnbuscar3);


        // BD
        Developerbbdd BaseDatos = new Developerbbdd(this);
        db = BaseDatos.getReadableDatabase();

        // Alternativa: query
        String[] campos = new String[] {"dni","fecha","temperatura","cabeza", "cansancio","respiracion","gusto", "olfato","mejoria","contacto", "PCRPos","fechaPCR","otrosSint"};
        //Invocación método para obtener todas las columnas de la base de datos, sin condiciones
        Cursor c = db.query("DATOS", campos, null, null, null, null, null);
        while(c.moveToNext()){
            //String IDDatos = c.getString(0);
            String dni = c.getString(0);
            String fecha = c.getString(1);
            String temperatura = c.getString(2);
            String cabeza = c.getString(3);
            String cansancio = c.getString(4);
            String respiracion = c.getString(5);
            String gusto = c.getString(6);
            String olfato = c.getString(7);
            String mejoria = c.getString(8);
            String contacto = c.getString(9);
            String PCRPos = c.getString(10);
            String fechaPCR = c.getString(11);
            String otrosSint = c.getString(12);
            txtResultado.append(dni + " - " + temperatura + " - " + fecha + " - " + cabeza + " "  + cansancio + "" + respiracion + "" +"\n");
        }

    }
}