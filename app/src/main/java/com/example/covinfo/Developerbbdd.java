package com.example.covinfo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Developerbbdd extends SQLiteOpenHelper {

    private static final String NOMBRE_BD="developerjp";
    private static final int VERSION_BD=2;
    private static final String TABLA_USUARIOS="CREATE TABLE USUARIOS(DNI CHAR(9) NOT NULL PRIMARY KEY, NOMBRE CHAR(50) NOT NULL, APELLIDOS CHAR(50) NOT NULL, TARJETASANITARIA CHAR(50) NOT NULL, EDAD INT NOT NULL)";
    private static final String TABLA_DATOS="CREATE TABLE DATOS(DNI CHAR(9) NOT NULL, TEMPERATURA FLOAT(3,1) NOT NULL, FECHA DATE NOT NULL, SINT1 CHAR(50) NOT NULL, SINT2 CHAR(50) NOT NULL, OTROS CHAR(50))";

    public Developerbbdd( Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_USUARIOS);
        db.execSQL(TABLA_DATOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE DATOS");
        db.execSQL("DROP TABLE USUARIOS");
        db.execSQL(TABLA_USUARIOS);
        db.execSQL(TABLA_DATOS);
    }

    public void agregarUsuarios(String dni, String nombre, String apellidos, String tarjetaSanitaria, String edad){
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null){
            bd.execSQL("INSERT INTO USUARIOS VALUES('"+dni+"','"+nombre+"','"+apellidos+"','"+tarjetaSanitaria+"','"+edad+"')");
            bd.close();
        }
    }

    public void agregarDatos(String dni, String temperatura, String fecha, String sint1, String sint2, String otros){
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null){
            bd.execSQL("INSERT INTO DATOS VALUES('"+dni+"','"+temperatura+"','"+fecha+"','"+sint1+"','"+sint2+"','"+otros+"')");
            bd.close();
        }
    }

}
