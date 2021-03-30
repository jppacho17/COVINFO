package com.example.covinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

public class graficaTemperaturas extends AppCompatActivity {

    LineChartView lineChartView;
    String[] axisData = {"03/01/21", "03/04/21", "03/06/21", "03/09/21", "03/15/21", "03/17/21", "03/18/21", "03/20/21", "03/22/21",
            "03/23/21", "03/25/21", "03/26/21"};
    float[] yAxisData = {(float) 34.4,(float) 34.9,(float) 35,(float) 37.2,(float) 35.7,(float) 36.3,(float) 37.2,(float) 37.6,(float) 38,(float) 39.1,(float) 38.6,(float) 37.9};

    private SQLiteDatabase db;

    Spinner comboPersonas;
    ArrayList<String> listaPersonas;
    ArrayList<Usuario> personasList;

    ArrayList<DatosUsuario> listaDatos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafica_temperaturas);


        comboPersonas = (Spinner) findViewById(R.id.spinnerUsus2);

        // BD
        Developerbbdd BaseDatos = new Developerbbdd(this);
        db = BaseDatos.getReadableDatabase();


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


        Toast.makeText(getApplicationContext(),"Mueve y arrastra para ver mejor los datos",Toast.LENGTH_LONG).show();
        comboPersonas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        lineChartView = findViewById(R.id.chart);

        List yAxisValues = new ArrayList();
        List axisValues = new ArrayList();


        Line line = new Line(yAxisValues).setColor(Color.parseColor("#9C27B0"));

        for (int i = 0; i < axisData.length; i++) {
            axisValues.add(i, new AxisValue(i).setLabel(axisData[i]));
        }

        for (int i = 0; i < yAxisData.length; i++) {
            yAxisValues.add(new PointValue(i, yAxisData[i]));
        }

        List lines = new ArrayList();
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setLines(lines);

        Axis axis = new Axis();
        axis.setValues(axisValues);
        axis.setTextSize(16);
        axis.setTextColor(Color.parseColor("#03A9F4"));
        data.setAxisXBottom(axis);

        Axis yAxis = new Axis();
        yAxis.setName(getString(R.string.temperatura2));
        yAxis.setTextColor(Color.parseColor("#03A9F4"));
        yAxis.setTextSize(16);
        data.setAxisYLeft(yAxis);

        lineChartView.setLineChartData(data);
        Viewport viewport = new Viewport(lineChartView.getMaximumViewport());
        viewport.top = 40;
        lineChartView.setMaximumViewport(viewport);
        lineChartView.setCurrentViewport(viewport);





    }
}