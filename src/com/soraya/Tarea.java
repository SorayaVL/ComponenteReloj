package com.soraya;

import java.util.Date;

public class Tarea {
    String Texto;
    Date hora;

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String texto) {
        Texto = texto;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Tarea() {
    }

    public Tarea(String texto, Date hora) {
        Texto = texto;
        this.hora = hora;
    }
}
