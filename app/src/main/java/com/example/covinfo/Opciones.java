package com.example.covinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Opciones extends AppCompatActivity {

    Button btnEstadisticas;
    Button btnTest;
    Button btnBBDD;
    Button btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);

        btnEstadisticas = (Button) findViewById(R.id.buttonEstadisticas);
        btnTest = (Button) findViewById(R.id.buttonTest);
        btnBBDD = (Button) findViewById(R.id.buttonBBDD);
        btnInfo = (Button) findViewById(R.id.buttonInfo);




        btnEstadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irWeb = new Intent(Opciones.this,import_web.class);
                startActivity(irWeb);
            }
        });

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irTest = new Intent(Opciones.this,test_covid_inicio.class);
                startActivity(irTest);
            }
        });

        btnBBDD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irBBDD = new Intent(Opciones.this,menubbddfinal.class);
                startActivity(irBBDD);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irBBDD = new Intent(Opciones.this,graficaTemperaturas.class);
                startActivity(irBBDD);
            }
        });
    }



}