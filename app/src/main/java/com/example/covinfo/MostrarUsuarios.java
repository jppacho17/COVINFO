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
import android.widget.TextView;

public class MostrarUsuarios extends AppCompatActivity {

    TextView txtUsu;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_usuarios2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fabUsu);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ir = new Intent(MostrarUsuarios.this,AnadirUsuario.class);
                startActivity(ir);
            }
        });

        txtUsu = (TextView) findViewById(R.id.txtUsuario);

        // BD
        Developerbbdd BaseDatos = new Developerbbdd(this);
        db = BaseDatos.getReadableDatabase();


        String[] campos = new String[] {"dni","fecha","temperatura","cabeza", "cansancio","respiracion","gusto", "olfato","mejoria","contacto", "PCRPos","fechaPCR","otrosSint"};
        Cursor c = db.rawQuery("SELECT * FROM USUARIOS",null);
        while(c.moveToNext()){
            //String IDDatos = c.getString(0);
            String dni = c.getString(0);
            String nombre = c.getString(1);
            String apellidos = c.getString(2);
            String fechaNac = c.getString(3);
            String tarjetaSan = c.getString(4);
            String medHab = c.getString(5);
            txtUsu.append(dni + " - " + nombre + " " + apellidos + " - " + fechaNac + " - "  + tarjetaSan + " - " + medHab + "" +"\n");
        }



    }
}