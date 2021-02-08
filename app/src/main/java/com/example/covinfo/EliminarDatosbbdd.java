package com.example.covinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EliminarDatosbbdd extends AppCompatActivity {

    private Button btnEliminar;
    private TextView dni;
    private TextView fecha;
    private TextView mostrarEliminados;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_datosbbdd);

        btnEliminar = findViewById(R.id.buttoneliminar2);
        dni = findViewById(R.id.edtDNI2);
        fecha = findViewById(R.id.edtFecha2);
        mostrarEliminados = findViewById(R.id.delPacMostrar);

        // Botón Enviar
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // BaseDatos


                Developerbbdd BaseDatos = new Developerbbdd(EliminarDatosbbdd.this);
                db = BaseDatos.getWritableDatabase();

                //Eliminamos el registro con el nombre del paciente y la fecha
                db.delete("DATOS", "dni=" + "'" + dni.getText().toString() + "'" +" AND fecha=" +
                        "'" + fecha.getText().toString() + "'",null);

                //Mostramos los datos eliminados
                mostrarEliminados.setText("Datos eliminados:" + "\n" + ": " +
                        dni.getText().toString() + "\n" + ": " + fecha.getText().toString());

            }
        });


















    }
}