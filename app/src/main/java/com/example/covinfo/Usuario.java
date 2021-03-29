package com.example.covinfo;

public class Usuario {

    private String dni;
    private String nombre;
    private String apellidos;
    private String fechaNac;
    private String tarjetaSanitaria;
    private String medHabituales;

    public Usuario (String dni, String nombre, String apellidos, String fechaNac, String tarjetaSanitaria, String medHabituales){
        this.dni=dni;
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.fechaNac=fechaNac;
        this.tarjetaSanitaria=tarjetaSanitaria;
        this.medHabituales=medHabituales;

    }

    public Usuario(){

    }

    public String getDni(){return dni;}

    public void setDni(String dni){this.dni=dni;}

    public String getNombre(){return nombre;}

    public void setNombre(String nombre){this.nombre=nombre;}

    public String getApellidos(){return apellidos;}

    public void setApellidos(String apellidos){this.apellidos=apellidos;}

    public String getFechaNac(){return fechaNac;}

    public void setFechaNac(String fechaNac){this.fechaNac=fechaNac;}

    public String getTarjetaSanitaria(){return tarjetaSanitaria;}

    public void setTarjetaSanitaria(String tarjetaSanitaria){this.tarjetaSanitaria=tarjetaSanitaria;}

    public String getMedHabituales(){return medHabituales;}

    public void setMedHabituales(String medHabituales){this.medHabituales=medHabituales;}
}
