package com.example.covinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ObtenerDatosbbdd extends AppCompatActivity {

    private TextView txtResultado;
    private Button btnVolver;
    private SQLiteDatabase db;

    /**
     * Realiza una consulta a la base de datos para mostrar los registros almacenados
     *
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obtener_datosbbdd);

        txtResultado = (TextView) findViewById(R.id.selectResultados);
        //btnVolver = (Button) findViewById(R.id.selectVolver);


        // BD
        Developerbbdd BaseDatos = new Developerbbdd(this);
        db = BaseDatos.getReadableDatabase();

        // Alternativa: query
        String[] campos = new String[] { "dni","temperatura","fecha","sint1", "sint2","otros"};
        //Invocación método para obtener todas las columnas de la base de datos, sin condiciones
        Cursor c = db.query("DATOS", campos, null, null, null, null, null);
        while(c.moveToNext()){
            String dni = c.getString(0);
            String temperatura = c.getString(1);
            String fecha = c.getString(2);
            String sint1 = c.getString(3);
            String sint2 = c.getString(4);
            String otros = c.getString(5);
            txtResultado.append(dni + " - " + temperatura + " - " + fecha + " - " + sint1 + " "  + sint2 + "" + otros + "" +"\n");
        }


    }
}