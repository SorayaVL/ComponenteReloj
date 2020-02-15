package com.soraya;

import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Label;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Reloj extends Label {

    private BooleanProperty formato24 = new SimpleBooleanProperty();
    private ObjectProperty<Date> horaAlarma = new SimpleObjectProperty<>();
    private SimpleDateFormat sdf24 = new SimpleDateFormat("HH:mm:ss");
    private SimpleDateFormat sdf12 = new SimpleDateFormat("hh:mm:ss a");
    Date horaActual = new Date();


    public boolean isFormato24() {
        return formato24.get();
    }

    public BooleanProperty formato24Property() {
        return formato24;
    }

    public Date getHoraAlarma() {
        return horaAlarma.get();
    }

    public ObjectProperty<Date> horaAlarmaProperty() {
        return horaAlarma;
    }

    public void setHoraAlarma(Date horaAlarma) {
        this.horaAlarma.set(horaAlarma);
    }

    public void setFormato24(boolean formato24) {
        this.formato24.set(formato24);
    }

    public SimpleDateFormat getSdf24() {
        return sdf24;
    }

    public void setSdf24(SimpleDateFormat sdf24) {
        this.sdf24 = sdf24;
    }

    public SimpleDateFormat getSdf12() {
        return sdf12;
    }

    public void setSdf12(SimpleDateFormat sdf12) {
        this.sdf12 = sdf12;
    }

    private boolean checkAlarma (Date horaActual, Date horaAlarma)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(horaActual);
        int horasActual, minActual, segActual, horasAlarma, minAlarma, segAlarma;
        horasActual=calendar.get(Calendar.HOUR_OF_DAY);
        minActual=calendar.get(Calendar.MINUTE);
        segActual=calendar.get(Calendar.SECOND);
        calendar.setTime(horaAlarma);
        horasAlarma=calendar.get(Calendar.HOUR_OF_DAY);
        minAlarma=calendar.get(Calendar.MINUTE);
        segAlarma=calendar.get(Calendar.SECOND);

        if (horasActual==horasAlarma && minActual==minAlarma && segActual==segAlarma)
            return true;
        else return false;
    }


    public Reloj(){
           Timer timer = new Timer();
           timer.schedule(new TimerTask() {
               @Override
               public void run() {

                   Platform.runLater(new Runnable() {
                       @Override
                       public void run() {
                           if (formato24.get()) {
                               setText(sdf24.format(horaActual));
                           } else
                               setText(sdf12.format(horaActual));

                       }
                   });

               }
           }, 0,1000);
       }

}
