package com.example.covinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import android.widget.DatePicker;
import android.widget.TextView;

public class AnadirDatosUsuario extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    EditText edtDNIUsuario, edtTemperaturaUsuario, edtFechaUsuario, edtOtrosSint, edtFechaPCR;
    Button btnAñadirDatos;
    CheckBox cabeza, respirar, cansancio, gusto, olfato;
    Switch mejoria, contactoPos, PRCPos;
    Spinner comboPersonas;
    ArrayList<String> listaPersonas;
    ArrayList<Usuario> personasList;
    private SQLiteDatabase db;
    String dniUsu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_datos_usuario);

        dniUsu="";

        //Recuperar datos elementos
        cabeza = findViewById(R.id.chkCabeza);
        respirar = findViewById(R.id.chkRespirar);
        cansancio = findViewById(R.id.chkCansacio);
        gusto = findViewById(R.id.chkGusto);
        olfato = findViewById(R.id.chkOlfato);

        //edtDNIUsuario =(EditText) findViewById(R.id.edtanadirDNI);

        edtTemperaturaUsuario =(EditText) findViewById(R.id.edtTempUser);
        edtFechaPCR =(EditText) findViewById(R.id.edtFechaPCR);
        edtOtrosSint =(EditText) findViewById(R.id.edtOtrosSintomas);

        mejoria = findViewById(R.id.swMejoria);
        contactoPos = findViewById(R.id.swContactoPos);
        PRCPos = findViewById(R.id.swPCR);

        edtFechaUsuario =(EditText) findViewById(R.id.edtFechaAnadir);


        btnAñadirDatos=(Button) findViewById(R.id.btnAnadirDatos1);

        edtFechaUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        //Copiado y pegado de version anterior, hay que ajustarlo
        final Developerbbdd developerbbdd=new Developerbbdd(getApplicationContext());

        db = developerbbdd.getWritableDatabase();

        comboPersonas = (Spinner) findViewById(R.id.spinnerUsus);

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

        comboPersonas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dniUsu = personasList.get(position).getDni();
                //Toast.makeText(getApplicationContext(),personasList.get(position).getDni(),Toast.LENGTH_SHORT).show();
                //edtOtrosSint.setText(personasList.get(position-1).getDni());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        db.close();

        btnAñadirDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Variables por defecto
                String dolorCabeza = "No";
                String cuestaRespirar = "No";
                String hayCansancio = "No";
                String perdidaGusto = "No";
                String perdidaOlfato = "No";
                String hayMejoria = "No";
                String hayContacto = "No";
                String hayPCRPos = "No";

                //Leo los valores de Checkboxes y Switches
                if(cabeza.isChecked()==true){
                    dolorCabeza = "Si";
                }
                if(respirar.isChecked()==true){
                    cuestaRespirar = "Si";
                }
                if(cansancio.isChecked()==true){
                    hayCansancio = "Si";
                }
                if(gusto.isChecked()==true){
                    perdidaGusto = "Si";
                }
                if(olfato.isChecked()==true){
                    perdidaOlfato = "Si";
                }

                if(mejoria.isChecked()==true){
                    hayMejoria = "Si";
                }
                if(contactoPos.isChecked()==true){
                    hayContacto = "Si";
                }
                if(PRCPos.isChecked()==true){
                    hayPCRPos = "Si";
                }

                //Toca revisar para meter los datos de la nueva version de la bbdd
                developerbbdd.agregarDatos(dniUsu,edtFechaUsuario.getText().toString(),edtTemperaturaUsuario.getText().toString(),dolorCabeza,hayCansancio,cuestaRespirar,perdidaGusto,perdidaOlfato,hayMejoria,hayContacto,hayPCRPos,edtFechaPCR.getText().toString(),edtOtrosSint.getText().toString());
                Toast.makeText(getApplicationContext(),"DATOS ALMACENADOS CORRECTAMENTE",Toast.LENGTH_SHORT).show();
                Intent ir = new Intent(AnadirDatosUsuario.this,mostrarDatosUsuario.class);
                startActivity(ir);
            }
        });


    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.SHORT).format(c.getTime());
        TextView textView = (TextView) findViewById(R.id.edtFechaAnadir);
        textView.setText(currentDateString);
    }
}