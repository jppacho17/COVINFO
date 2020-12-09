package com.example.covinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button  btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Invocamos contructor de la superclase
        super.onCreate(savedInstanceState);
        //Hacemos que el contenido de esta vista sean los recursos del fichero XML
        setContentView(R.layout.activity_main);
        //TEST Javi, obtenemos referencia a la cadena de texto "pacho"
       // String string = getString(R.string.pacho);
        //Obtenemos referencia a TextViewID
       // TextView textView = (TextView) findViewById(R.id.textViewID);

        btnSiguiente = (Button) findViewById(R.id.buttonPPrincipal);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}