package com.example.covinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class AnadirDatosUsuario extends AppCompatActivity {

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
        edtFechaUsuario =(EditText) findViewById(R.id.edtFechaAnadir);
        edtTemperaturaUsuario =(EditText) findViewById(R.id.edtTempUser);
        edtFechaPCR =(EditText) findViewById(R.id.edtFechaPCR);
        edtOtrosSint =(EditText) findViewById(R.id.edtOtrosSintomas);

        mejoria = findViewById(R.id.swMejoria);
        contactoPos = findViewById(R.id.swContactoPos);
        PRCPos = findViewById(R.id.swPCR);



        //Copiado y pegado de version anterior, hay que ajustarlo todo
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


                developerbbdd.agregarDatos(edtDNIUsuario.getText().toString(),edtTemperatura1.getText().toString(),edtFecha1.getText().toString(),edtSint11.getText().toString(),edtSint21.getText().toString(),edtOtros1.getText().toString());
                Toast.makeText(getApplicationContext(),"DATOS ALMACENADOS CORRECTAMENTE",Toast.LENGTH_SHORT).show();
            }
        });

    }
}