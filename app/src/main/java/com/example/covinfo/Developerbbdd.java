package com.example.covinfo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Developerbbdd extends SQLiteOpenHelper {

    private static final String NOMBRE_BD="developerjp";
    private static final int VERSION_BD=32;
    private static final String TABLA_USUARIOS="CREATE TABLE USUARIOS(DNI CHAR(9) NOT NULL PRIMARY KEY, NOMBRE CHAR(50) NOT NULL, APELLIDOS CHAR(50) NOT NULL, FECHANAC DATE NOT NULL, TARJETASANITARIA CHAR(50) NOT NULL, MEDICAMENTOSHAB CHAR(50))";
    private static final String TABLA_DATOS="CREATE TABLE DATOS(DNI CHAR(9) NOT NULL, FECHA DATE NOT NULL, TEMPERATURA FLOAT(3,1) NOT NULL, CABEZA CHAR(9) NOT NULL,  CANSANCIO CHAR(9) NOT NULL,  RESPIRACION CHAR(9) NOT NULL,  GUSTO CHAR(9) NOT NULL, OLFATO CHAR(9) NOT NULL,  MEJORIA CHAR(9) NOT NULL, CONTACTO CHAR(9) NOT NULL, PCRPOS  CHAR(9) NOT NULL, FECHAPCR DATE , OTROSSINT CHAR(50))";
    private static final String TABLA_MEDICO="CREATE TABLE MEDICO(CENTROMED CHAR(20), CIUDAD CHAR(20), NOMBREMED CHAR(50), TFNOMED INT, EMAILMED CHAR(50))";
    //private static final String TABLA_MEDICOS="";


    public Developerbbdd( Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_USUARIOS);
        db.execSQL(TABLA_DATOS);
        db.execSQL(TABLA_MEDICO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE DATOS");
        db.execSQL("DROP TABLE USUARIOS");
        db.execSQL("DROP TABLE MEDICO");
        db.execSQL(TABLA_USUARIOS);
        db.execSQL(TABLA_DATOS);
        db.execSQL(TABLA_MEDICO);
        db.execSQL("INSERT INTO MEDICO VALUES('CentroMedico','Cualquiera','Nombre del Medico','666666666','email_medico@medico.com')");
        //agregarMedico("CentroMedico","Ciudad","Nombre del Medico","666666666","email_medico@gmail.com");
    }

    public void agregarUsuarios(String dni, String nombre, String apellidos, String fechaNac, String tarjetaSanitaria, String medicamentosHab){
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null){
            bd.execSQL("INSERT INTO USUARIOS VALUES('"+dni+"','"+nombre+"','"+apellidos+"','"+fechaNac+"','"+tarjetaSanitaria+"','"+medicamentosHab+"')");
            bd.close();
        }
    }

    public void agregarDatos(String dni, String fecha, String temperatura, String cabeza, String cansancio, String respiracion, String gusto, String olfato, String mejoria, String contacto, String PCRPos, String fechaPCR, String otrosSint){
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null){
            bd.execSQL("INSERT INTO DATOS VALUES('"+dni+"','"+fecha+"','"+temperatura+"','"+cabeza+"','"+cansancio+"','"+respiracion+"','"+gusto+"','"+olfato+"','"+mejoria+"','"+contacto+"','"+PCRPos+"','"+fechaPCR+"','"+otrosSint+"')");
            bd.close();
        }
    }

    public void agregarMedico(String centroMed, String ciudad, String nombreMed, String telefonoMed, String emailMed){
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null){
            bd.execSQL("INSERT INTO MEDICO VALUES('"+centroMed+"','"+ciudad+"','"+nombreMed+"','"+telefonoMed+"','"+emailMed+"')");
            bd.close();
        }
    }


}
