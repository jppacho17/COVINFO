package com.example.covinfo;

public class DatosUsuario {

    private String fecha;
    private String temperatura;
    private String pcrPos;
    private String dni;
    private String cabeza;
    private String cansancio;
    private String respiracion;
    private String gusto;
    private String olfato;
    private String mejoria;
    private String contacto;
    private String fechapcr;
    private String otrosSintomas;

    public DatosUsuario(){


    }

    public DatosUsuario(String fecha, String temperatura, String pcrPos, String dni, String cabeza, String cansancio, String respiracion, String gusto, String olfato, String mejoria, String contacto, String fechapcr, String otrosSintomas) {
        this.fecha = fecha;
        this.temperatura = temperatura;
        this.pcrPos = pcrPos;
        this.dni = dni;
        this.cabeza = cabeza;
        this.cansancio = cansancio;
        this.respiracion = respiracion;
        this.gusto = gusto;
        this.olfato = olfato;
        this.mejoria = mejoria;
        this.contacto = contacto;
        this.fechapcr = fechapcr;
        this.otrosSintomas = otrosSintomas;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getPcrPos() {
        return pcrPos;
    }

    public void setPcrPos(String pcrPos) {
        this.pcrPos = pcrPos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCabeza() {
        return cabeza;
    }

    public void setCabeza(String cabeza) {
        this.cabeza = cabeza;
    }

    public String getCansancio() {
        return cansancio;
    }

    public void setCansancio(String cansancio) {
        this.cansancio = cansancio;
    }

    public String getRespiracion() {
        return respiracion;
    }

    public void setRespiracion(String respiracion) {
        this.respiracion = respiracion;
    }

    public String getGusto() {
        return gusto;
    }

    public void setGusto(String gusto) {
        this.gusto = gusto;
    }

    public String getOlfato() {
        return olfato;
    }

    public void setOlfato(String olfato) {
        this.olfato = olfato;
    }

    public String getMejoria() {
        return mejoria;
    }

    public void setMejoria(String mejoria) {
        this.mejoria = mejoria;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getFechapcr() {
        return fechapcr;
    }

    public void setFechapcr(String fechapcr) {
        this.fechapcr = fechapcr;
    }

    public String getOtrosSintomas() {
        return otrosSintomas;
    }

    public void setOtrosSintomas(String otrosSintomas) {
        this.otrosSintomas = otrosSintomas;
    }
}
