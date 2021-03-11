package com.example.covinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import android.widget.DatePicker;
import android.widget.TextView;

public class AnadirDatosUsuario extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    EditText edtDNIUsuario, edtTemperaturaUsuario, edtFechaUsuario, edtOtrosSint, edtFechaPCR;
    Button btnAñadirDatos;
    CheckBox cabeza, respirar, cansancio, gusto, olfato;
    Switch mejoria, contactoPos, PRCPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_datos_usuario);

        //Recuperar datos elementos
        cabeza = findViewById(R.id.chkCabeza);
        respirar = findViewById(R.id.chkRespirar);
        cansancio = findViewById(R.id.chkCansacio);
        gusto = findViewById(R.id.chkGusto);
        olfato = findViewById(R.id.chkOlfato);

        edtDNIUsuario =(EditText) findViewById(R.id.edtanadirDNI);

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

        btnAñadirDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Variables por defecto
                String dolorCabeza = "no";
                String cuestaRespirar = "no";
                String hayCansancio = "no";
                String perdidaGusto = "no";
                String perdidaOlfato = "no";
                String hayMejoria = "no";
                String hayContacto = "no";
                String hayPCRPos = "no";

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
                developerbbdd.agregarDatos(edtDNIUsuario.getText().toString(),edtFechaUsuario.getText().toString(),edtTemperaturaUsuario.getText().toString(),dolorCabeza,hayCansancio,cuestaRespirar,perdidaGusto,perdidaOlfato,hayMejoria,hayContacto,hayPCRPos,edtFechaPCR.getText().toString(),edtOtrosSint.getText().toString());
                Toast.makeText(getApplicationContext(),"DATOS ALMACENADOS CORRECTAMENTE",Toast.LENGTH_SHORT).show();
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