package com.soraya.test.fxml;

import com.soraya.Reloj;
import com.soraya.SettingAlarm;
import com.soraya.Tarea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;


public class PantallaController implements Initializable {
    @FXML
    private Reloj reloj;

    @FXML
    private TextField hora;

    @FXML
    private TextField minutos;

    @FXML
    private TextField segundos;

    @FXML
    private Button btnAddTask;

    @FXML
    private TextField tfTexto;
    @FXML
    private TableView<Tarea> tvTareas;

    @FXML
    private Button btnBorrarTarea;

    private Tarea tarea;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        reloj.comienza();


    }

    @FXML
    void addTarea(ActionEvent event) throws ParseException {
        String horaTarea = hora.getText()+":"+minutos.getText()+":"+segundos.getText();
        System.out.println(horaTarea);
        tvTareas.setItems(reloj.getTareaList());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = simpleDateFormat.parse(horaTarea);
        tarea = new Tarea(tfTexto.getText(),date);
        reloj.registrarTarea(tarea);
        reloj.addSettingAlarm(new SettingAlarm() {
            @Override
            public void ejecuta(Tarea tarea) {
                System.out.println(tarea);
            }
        });


    }


    @FXML
    void eliminarTarea(ActionEvent event) {
        tarea=tvTareas.getSelectionModel().getSelectedItem();
        reloj.borrarTarea(tarea);

    }



}
