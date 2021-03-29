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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class mostrarDatosUsuario extends AppCompatActivity {

    private TextView txtResultado,txtDNI;
    private Button btnBuscar;
    private SQLiteDatabase db;
    Spinner comboPersonas;
    ArrayList<String> listaPersonas;
    ArrayList<Usuario> personasList;

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
        //txtDNI = (TextView) findViewById(R.id.buscarporDNI);
        comboPersonas = (Spinner) findViewById(R.id.spinnerUsuario);

        // BD
        Developerbbdd BaseDatos = new Developerbbdd(this);
        db = BaseDatos.getReadableDatabase();

        //Generar lista personas
        Usuario persona=null;
        personasList = new ArrayList<Usuario>();
        Cursor cursor = db.rawQuery("SELECT * FROM USUARIOS",null);
        while(cursor.moveToNext()){
            persona = new Usuario();
            persona.setDni(cursor.getString(0));
            persona.setNombre(cursor.getString(1));
            persona.setApellidos(cursor.getString(2));
            persona.setFechaNac(cursor.getString(3));
            persona.setTarjetaSanitaria(cursor.getString(4));
            persona.setMedHabituales(cursor.getString(5));

            personasList.add(persona);

        }

        //ObtenerLista
        listaPersonas=new ArrayList<String>();
        listaPersonas.add("Seleccione");
        for (int i=0;i<personasList.size();i++){
            listaPersonas.add(personasList.get(i).getDni()+" - "+personasList.get(i).getNombre()+" - "+personasList.get(i).getApellidos());
        }

        ArrayAdapter<CharSequence> adaptador=new ArrayAdapter(this, android.R.layout.simple_spinner_item,listaPersonas);
        comboPersonas.setAdapter(adaptador);

        comboPersonas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                txtResultado.setText("");
                if (position!=0){
                    String[] campos = new String[] {"dni","fecha","temperatura","cabeza", "cansancio","respiracion","gusto", "olfato","mejoria","contacto", "PCRPos","fechaPCR","otrosSint"};
                    Cursor c = db.rawQuery("SELECT * FROM DATOS WHERE dni="+personasList.get(position-1).getDni(),null);
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

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





    }
}