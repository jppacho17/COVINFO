package com.example.covinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;


public class AnadirUsuario extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    EditText edtdni, edtNombre, edtApellidos, edtFechaNac, edtTarjetaSanitaria,edtMedHab;
    Button btnAnadirUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_usuario);

        edtdni =(EditText) findViewById(R.id.edtDNIUsu);
        edtNombre =(EditText) findViewById(R.id.edtNombreUsu);
        edtApellidos =(EditText) findViewById(R.id.edtApellidosUsu);
        edtFechaNac =(EditText) findViewById(R.id.edtFechaNacimientoUsu);
        edtTarjetaSanitaria =(EditText) findViewById(R.id.edtTarjetaSanitariaUsu);
        edtMedHab =(EditText) findViewById(R.id.edtMedHabituales);

        btnAnadirUsuario =(Button) findViewById(R.id.btnAnadirUsu);

        edtFechaNac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        //Copiado y pegado de version anterior, hay que ajustarlo
        final Developerbbdd developerbbdd=new Developerbbdd(getApplicationContext());

        btnAnadirUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                developerbbdd.agregarUsuarios(edtdni.getText().toString(),edtNombre.getText().toString(),edtApellidos.getText().toString(),edtFechaNac.getText().toString(),edtTarjetaSanitaria.getText().toString(),edtMedHab.getText().toString());
                Toast.makeText(getApplicationContext(),"USUARIO CREADO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
                //Intent ir = new Intent(AnadirUsuario.this,MostrarUsuarios.class);
                //startActivity(ir);
                finish();
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
        TextView textView = (TextView) findViewById(R.id.edtFechaNacimientoUsu);
        textView.setText(currentDateString);
    }
}