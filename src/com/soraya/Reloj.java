package com.soraya;

import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;

import java.text.SimpleDateFormat;
import java.util.*;

public class Reloj extends Label {

    private BooleanProperty formato24 = new SimpleBooleanProperty();
    private ObjectProperty<Date> horaAlarma = new SimpleObjectProperty<>();
    public ObservableList<Tarea> tareaList = FXCollections.observableArrayList();
    private SettingAlarm settingAlarm;
    private SimpleDateFormat sdf24 = new SimpleDateFormat("HH:mm:ss");
    private SimpleDateFormat sdf12 = new SimpleDateFormat("hh:mm:ss a");
    Date horaActual = new Date();
    Timer timer = new Timer();

    public ObservableList<Tarea> getTareaList() {
        return tareaList;
    }

    public void setTareaList(ObservableList<Tarea> tareaList) {
        this.tareaList = tareaList;
    }

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

    public void addSettingAlarm(SettingAlarm settingAlarm) {
        this.settingAlarm = settingAlarm;
    }


    private boolean compruebaTarea(Date horaActual, Date horaTarea) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(horaActual);
        int horasActual, minActual, segActual, horasTarea, minTarea, segTarea;
        horasActual = calendar.get(Calendar.HOUR_OF_DAY);
        minActual = calendar.get(Calendar.MINUTE);
        segActual = calendar.get(Calendar.SECOND);
        calendar.setTime(horaTarea);
        horasTarea = calendar.get(Calendar.HOUR_OF_DAY);
        minTarea = calendar.get(Calendar.MINUTE);
        segTarea = calendar.get(Calendar.SECOND);

        if (horasActual == horasTarea && minActual == minTarea && segActual == segTarea)
            return true;
        else return false;
    }

    public Reloj() {
    }

    public void registrarTarea(Tarea tarea) {
        tareaList.add(tarea);
    }

    public void borrarTarea(Tarea tarea) {
        tareaList.remove(tarea);
    }

    public void comienza() {

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                horaActual = new Date();
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if (formato24.get()) {
                            setText(sdf24.format(horaActual));
                        } else
                            setText(sdf12.format(horaActual));
                        for (Tarea tarea : tareaList) {
                            if (compruebaTarea(horaActual, tarea.getHoraSinFormato())) {
                                if (settingAlarm != null) {
                                    settingAlarm.ejecuta(tarea);
                                }

                            }
                        }
                    }
                });
            }
        }, 0, 1000);

    }

    public void cierraHilo(){
        timer.cancel();
    }

}
