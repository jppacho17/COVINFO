package com.example.covinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class test_covid_p3 extends AppCompatActivity {

    Button btnno;
    Button btnsi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_covid_p3);


        btnno = (Button) findViewById(R.id.buttonP3no);
        btnsi = (Button) findViewById(R.id.buttonP3yes);

        btnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irNo = new Intent(test_covid_p3.this,test_covid_casa.class);
                startActivity(irNo);
            }
        });

        btnsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irSi = new Intent(test_covid_p3.this,test_covid_Sos.class);
                startActivity(irSi);
            }
        });

    }
}