package com.example.covinfo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    ArrayList<DatosUsuario> listaDatos;
    RecyclerView recyclerDatos;

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

        //txtResultado = (TextView) findViewById(R.id.datosUsuario);
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
        //listaPersonas.add("Seleccione");
        for (int i=0;i<personasList.size();i++){
            listaPersonas.add(personasList.get(i).getDni()+" - "+personasList.get(i).getNombre()+" "+personasList.get(i).getApellidos());
        }

        ArrayAdapter<CharSequence> adaptador=new ArrayAdapter(this, android.R.layout.simple_spinner_item,listaPersonas);
        comboPersonas.setAdapter(adaptador);

        listaDatos=new ArrayList<>();
        recyclerDatos = (RecyclerView) findViewById(R.id.recyclerDatos);
        recyclerDatos.setLayoutManager(new LinearLayoutManager(this));


        comboPersonas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //txtResultado.setText("");
                listaDatos.clear();
                AdaptadorDatos adapter=new AdaptadorDatos(listaDatos);
                recyclerDatos.setAdapter(adapter);
                    DatosUsuario datosUsuario=null;
                    Cursor cursor = db.rawQuery("SELECT * FROM DATOS WHERE dni="+personasList.get(position).getDni(),null);
                    while(cursor.moveToNext()){
                        datosUsuario=new DatosUsuario();
                        datosUsuario.setDni(cursor.getString(0));
                        datosUsuario.setFecha(cursor.getString(1));
                        datosUsuario.setTemperatura(cursor.getString(2));
                        datosUsuario.setCabeza(cursor.getString(3));
                        datosUsuario.setCansancio(cursor.getString(4));
                        datosUsuario.setRespiracion(cursor.getString(5));
                        datosUsuario.setGusto(cursor.getString(6));
                        datosUsuario.setOlfato(cursor.getString(7));
                        datosUsuario.setMejoria(cursor.getString(8));
                        datosUsuario.setContacto(cursor.getString(9));
                        datosUsuario.setPcrPos(cursor.getString(10));
                        datosUsuario.setFechapcr(cursor.getString(11));
                        datosUsuario.setOtrosSintomas(cursor.getString(12));

                        listaDatos.add(datosUsuario);

                    }

                //AdaptadorDatos adapter=new AdaptadorDatos(listaDatos);
                recyclerDatos.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





    }
}