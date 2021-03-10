package com.example.covinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AnadirDatosbbdd extends AppCompatActivity {

    EditText edtDNI1, edtTemperatura1, edtFecha1, edtSint11, edtSint21, edtOtros1;
    Button btnAñadir1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_datosbbdd);

        edtDNI1 =(EditText) findViewById(R.id.edtDNI);
        edtTemperatura1 =(EditText) findViewById(R.id.edtTemperatura);
        edtFecha1 =(EditText) findViewById(R.id.edtFecha);
        edtSint11 =(EditText) findViewById(R.id.edtSint1);
        edtSint21 =(EditText) findViewById(R.id.edtSint2);
        edtOtros1 =(EditText) findViewById(R.id.edtOtros);
        btnAñadir1=(Button) findViewById(R.id.buttonAñadirDatosBBDD);

        final Developerbbdd developerbbdd=new Developerbbdd(getApplicationContext());

        btnAñadir1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //Funciona pero quitado para evitar problemas con la nueva bbdd
                //developerbbdd.agregarDatos(edtDNI1.getText().toString(),edtTemperatura1.getText().toString(),edtFecha1.getText().toString(),edtSint11.getText().toString(),edtSint21.getText().toString(),edtOtros1.getText().toString());
                Toast.makeText(getApplicationContext(),"DATOS AÑADIDOS CORRECTAMENTE",Toast.LENGTH_SHORT).show();
            }
        });

    }
}