package com.soraya;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tarea {
    String descripcion;
    Date hora;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getHoraSinFormato() {
        return hora;
    }

    public String getHora(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        String horaFormateada = simpleDateFormat.format(getHoraSinFormato());
        return horaFormateada;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Tarea(String descripcion, Date hora) {
        this.descripcion = descripcion;
        this.hora = hora;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
