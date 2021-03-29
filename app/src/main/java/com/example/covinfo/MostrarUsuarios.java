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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MostrarUsuarios extends AppCompatActivity {

    TextView txtUsu;
    private SQLiteDatabase db;
    ListView listViewPersonas;
    ArrayList<String> listaInformacion;
    ArrayList<Usuario> listaUsuarios;

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

        //txtUsu = (TextView) findViewById(R.id.txtUsuario);
        listViewPersonas = (ListView) findViewById(R.id.listViewPersonas);



        // BD
        Developerbbdd BaseDatos = new Developerbbdd(this);
        db = BaseDatos.getReadableDatabase();

        Usuario usuario=null;
        listaUsuarios=new ArrayList<Usuario>();
        Cursor cursor = db.rawQuery("SELECT * FROM USUARIOS",null);
        while(cursor.moveToNext()){
            usuario = new Usuario();
            usuario.setDni(cursor.getString(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setApellidos(cursor.getString(2));
            usuario.setFechaNac(cursor.getString(3));
            usuario.setTarjetaSanitaria(cursor.getString(4));
            usuario.setMedHabituales(cursor.getString(5));

            listaUsuarios.add(usuario);

        }

        //ObtenerLista
        listaInformacion=new ArrayList<String>();
        for (int i=0;i<listaUsuarios.size();i++){

            listaInformacion.add(listaUsuarios.get(i).getDni()+" - "+listaUsuarios.get(i).getNombre()+" "+listaUsuarios.get(i).getApellidos()+" - "+listaUsuarios.get(i).getFechaNac());
        }

        ArrayAdapter adaptador= new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaInformacion);
        listViewPersonas.setAdapter(adaptador);





    }
}