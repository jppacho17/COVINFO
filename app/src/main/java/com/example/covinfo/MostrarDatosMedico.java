package com.example.covinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MostrarDatosMedico extends AppCompatActivity {

    Button btnVolver,btnModificar;
    EditText edtCentroMed, edtCiu, edtNombreMed, edtTelfMed, edtEmailMed;

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos_medico);

        btnVolver   = (Button) findViewById(R.id.btnVolverMedico);
        btnModificar   = (Button) findViewById(R.id.btnModificarMedico);
        edtCentroMed    = (EditText) findViewById(R.id.edtCentroMedico);
        //edtCiu    = (EditText) findViewById(R.id.edtCiudad);
        edtNombreMed    = (EditText) findViewById(R.id.edtNombreMedico);
        edtTelfMed    = (EditText) findViewById(R.id.edtTelefonoMedico);
        edtEmailMed    = (EditText) findViewById(R.id.edtEmailMedico);

        String ciudad = "Cualquiera";
        // BD
        Developerbbdd BaseDatos = new Developerbbdd(this);
        db = BaseDatos.getReadableDatabase();
        //db.execSQL("INSERT INTO MEDICO VALUES('CentroMedico','Cualquiera','Nombre del Medico','666666666','email_medico@medico.com')");

        String[] campos = new String[] {"centroMed","ciudadMed","nombreMed","telefonoMed", "emailMed"};
        Cursor c = db.rawQuery("SELECT * FROM MEDICO",null);
        while(c.moveToNext()) {
            //String IDDatos = c.getString(0);
            String centroMed = c.getString(0);
            String ciudadMed = c.getString(1);
            String nombreMed = c.getString(2);
            String telefonoMed = c.getString(3);
            String emailMed = c.getString(4);

            Toast.makeText(MostrarDatosMedico.this,"Cambia los datos que sean necesarios y pulsa en Modificar",Toast.LENGTH_LONG).show();
            edtCentroMed.setText(centroMed);
            edtNombreMed.setText(nombreMed);
            edtTelfMed.setText(telefonoMed);
            edtEmailMed.setText(emailMed);
            //txtResultado.append(dni + " - " + temperatura + " - " + fecha + " - " + cabeza + " "  + cansancio + "" + respiracion + "" +"\n");
        }

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el nuevo registro de valores a actualizar
                ContentValues valores = new ContentValues();
                valores.put("CENTROMED",edtCentroMed.getText().toString());
                valores.put("NOMBREMED",edtNombreMed.getText().toString());
                valores.put("TFNOMED",edtTelfMed.getText().toString());
                valores.put("EMAILMED",edtEmailMed.getText().toString());
                db.update("MEDICO",valores,"CIUDAD='Cualquiera'",null);

                Toast.makeText(MostrarDatosMedico.this,"DATOS MODIFICADOS CORRECTAMENTE",Toast.LENGTH_LONG).show();

                Intent ir = new Intent(MostrarDatosMedico.this,opcionesDUM.class);
                startActivity(ir);
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(MostrarDatosMedico.this,opcionesDUM.class);
                startActivity(ir);
            }
        });
    }
}