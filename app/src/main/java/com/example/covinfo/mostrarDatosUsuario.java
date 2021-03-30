package com.example.covinfo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class mostrarDatosUsuario extends AppCompatActivity {

    private TextView txtResultado,txtDNI;
    private Button btnBuscar;
    private SQLiteDatabase db;
    Spinner comboPersonas;
    ArrayList<String> listaPersonas;
    ArrayList<Usuario> personasList;

    ArrayList<DatosUsuario> listaDatos;
    RecyclerView recyclerDatos;

    String nombreEnfermo="";
    String apellidoEnfermo="";
    String dniEnfermo="";
    String nombreMedico="";
    String emailMedico="";

    String sintomasEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos_usuario);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ir = new Intent(mostrarDatosUsuario.this,AnadirDatosUsuario.class);
                startActivity(ir);
            }
        });



        FloatingActionButton fab2 = findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sintomasEnviar="";
                for(int i=0;i<listaDatos.size();i++){
                    sintomasEnviar=sintomasEnviar+" | ";
                    sintomasEnviar=sintomasEnviar+listaDatos.get(i).getDni();
                    sintomasEnviar=sintomasEnviar+" | ";
                    sintomasEnviar=sintomasEnviar+listaDatos.get(i).getFecha();
                    sintomasEnviar=sintomasEnviar+" |     ";
                    sintomasEnviar=sintomasEnviar+listaDatos.get(i).getTemperatura();
                    sintomasEnviar=sintomasEnviar+"      |      ";
                    sintomasEnviar=sintomasEnviar+listaDatos.get(i).getCabeza();
                    sintomasEnviar=sintomasEnviar+"     |     ";
                    sintomasEnviar=sintomasEnviar+listaDatos.get(i).getCansancio();
                    sintomasEnviar=sintomasEnviar+"     |     ";
                    sintomasEnviar=sintomasEnviar+listaDatos.get(i).getRespiracion();
                    sintomasEnviar=sintomasEnviar+"    |     ";
                    sintomasEnviar=sintomasEnviar+listaDatos.get(i).getGusto();
                    sintomasEnviar=sintomasEnviar+"     |     ";
                    sintomasEnviar=sintomasEnviar+listaDatos.get(i).getOlfato();
                    sintomasEnviar=sintomasEnviar+"    |    ";
                    sintomasEnviar=sintomasEnviar+listaDatos.get(i).getMejoria();
                    sintomasEnviar=sintomasEnviar+"     |     ";
                    sintomasEnviar=sintomasEnviar+listaDatos.get(i).getContacto();
                    sintomasEnviar=sintomasEnviar+"     |    ";
                    sintomasEnviar=sintomasEnviar+listaDatos.get(i).getPcrPos();
                    sintomasEnviar=sintomasEnviar+"     |     ";
                    sintomasEnviar=sintomasEnviar+listaDatos.get(i).getOtrosSintomas();
                    sintomasEnviar=sintomasEnviar+"<br>";
                }
                sendEmailWithGmail("acovinfo@gmail.com","covinfo2021",emailMedico,"[COVINFO] Seguimiento paciente "+nombreEnfermo+" "+apellidoEnfermo+" - "+ dniEnfermo,"Hola "+nombreMedico+","+"<br>"+"<br>"+"Estos son los datos de seguimiento del paciente: "+nombreEnfermo+" "+apellidoEnfermo+" - "+ dniEnfermo+"<br>"+"<br>"+getString(R.string.cabeceraEmail)+"<br>"+sintomasEnviar);
                Snackbar.make(view, "Se han enviado los datos de "+nombreEnfermo+" al médico "+nombreMedico+" ("+emailMedico+")", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        //txtResultado = (TextView) findViewById(R.id.datosUsuario);
        //txtDNI = (TextView) findViewById(R.id.buscarporDNI);
        comboPersonas = (Spinner) findViewById(R.id.spinnerUsuario);

        // BD
        Developerbbdd BaseDatos = new Developerbbdd(this);
        db = BaseDatos.getReadableDatabase();

        //Para sacar el nombre y correo del medico
        Cursor c2 = db.rawQuery("SELECT * FROM MEDICO",null);
        while(c2.moveToNext()) {
            //String IDDatos = c.getString(0);
            String centroMed = c2.getString(0);
            String ciudadMed = c2.getString(1);
            nombreMedico = c2.getString(2);
            String telefonoMed = c2.getString(3);
            emailMedico = c2.getString(4);

        }

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

        listaDatos=new ArrayList<>();
        recyclerDatos = (RecyclerView) findViewById(R.id.recyclerDatos);
        recyclerDatos.setLayoutManager(new LinearLayoutManager(this));


        comboPersonas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //txtResultado.setText("");
                listaDatos.clear();
                AdaptadorDatos adapter=new AdaptadorDatos(listaDatos);
                recyclerDatos.setAdapter(adapter);
                nombreEnfermo=personasList.get(position).getNombre();
                apellidoEnfermo=personasList.get(position).getApellidos();
                dniEnfermo=personasList.get(position).getDni();
                    DatosUsuario datosUsuario=null;
                    Cursor cursor = db.rawQuery("SELECT * FROM DATOS WHERE dni="+personasList.get(position).getDni(),null);
                    while(cursor.moveToNext()){
                        datosUsuario=new DatosUsuario();
                        datosUsuario.setDni(cursor.getString(0));
                        datosUsuario.setFecha(cursor.getString(1));
                        datosUsuario.setTemperatura(cursor.getString(2));
                        datosUsuario.setCabeza(cursor.getString(3));
                        datosUsuario.setCansancio(cursor.getString(4));
                        datosUsuario.setRespiracion(cursor.getString(5));
                        datosUsuario.setGusto(cursor.getString(6));
                        datosUsuario.setOlfato(cursor.getString(7));
                        datosUsuario.setMejoria(cursor.getString(8));
                        datosUsuario.setContacto(cursor.getString(9));
                        datosUsuario.setPcrPos(cursor.getString(10));
                        datosUsuario.setFechapcr(cursor.getString(11));
                        datosUsuario.setOtrosSintomas(cursor.getString(12));

                        listaDatos.add(datosUsuario);

                    }

                 adapter.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         Toast.makeText(getApplicationContext(),"Datos de la fecha: "+listaDatos.get(recyclerDatos.getChildAdapterPosition(v)).getFecha()+"\n"+"Temperatura: "+listaDatos.get(recyclerDatos.getChildAdapterPosition(v)).getTemperatura()+"\n"+"Dolor de cabeza: "+listaDatos.get(recyclerDatos.getChildAdapterPosition(v)).getCabeza()+"\n"+"Cansancio: "+listaDatos.get(recyclerDatos.getChildAdapterPosition(v)).getCansancio()+"\n"+
                                 "Cuesta respirar: "+listaDatos.get(recyclerDatos.getChildAdapterPosition(v)).getRespiracion()+"\n"+"Perdida del gusto: "+listaDatos.get(recyclerDatos.getChildAdapterPosition(v)).getGusto()+"\n"+"Perdida del olfato: "+listaDatos.get(recyclerDatos.getChildAdapterPosition(v)).getOlfato()+"\n"+"Mejoría: "+listaDatos.get(recyclerDatos.getChildAdapterPosition(v)).getMejoria()+"\n"
                                 +"Contacto con Positivo: "+listaDatos.get(recyclerDatos.getChildAdapterPosition(v)).getContacto()+"\n"+"PCR positiva: "+listaDatos.get(recyclerDatos.getChildAdapterPosition(v)).getPcrPos()+"\n"+"Otros síntomas: "+listaDatos.get(recyclerDatos.getChildAdapterPosition(v)).getOtrosSintomas(),Toast.LENGTH_LONG).show();
                     }
                 });

                //AdaptadorDatos adapter=new AdaptadorDatos(listaDatos);
                recyclerDatos.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





    }

    /**
     * Send email with Gmail service.
     */
    private void sendEmailWithGmail(final String recipientEmail, final String recipientPassword,
                                    String to, String subject, String message) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(recipientEmail, recipientPassword);
            }
        });

        SenderAsyncTask task = new SenderAsyncTask(session, recipientEmail, to, subject, message);
        task.execute();
    }

    /**
     * AsyncTask to send email
     */
    private class SenderAsyncTask extends AsyncTask<String, String, String> {

        private String from, to, subject, message;
        private ProgressDialog progressDialog;
        private Session session;

        public SenderAsyncTask(Session session, String from, String to, String subject, String message) {
            this.session = session;
            this.from = from;
            this.to = to;
            this.subject = subject;
            this.message = message;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(mostrarDatosUsuario.this, "", "Enviando email", true);
            progressDialog.setCancelable(false);
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                Message mimeMessage = new MimeMessage(session);
                mimeMessage.setFrom(new InternetAddress(from));
                mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
                mimeMessage.setSubject(subject);
                mimeMessage.setContent(message, "text/html; charset=utf-8");
                Transport.send(mimeMessage);
            } catch (MessagingException e) {
                e.printStackTrace();
                return e.getMessage();
            } catch (Exception e) {
                e.printStackTrace();
                return e.getMessage();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            progressDialog.setMessage(values[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            progressDialog.dismiss();
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
        }
    }

}