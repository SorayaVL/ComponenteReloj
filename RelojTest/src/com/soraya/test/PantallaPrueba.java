package com.soraya.test;
import com.soraya.Reloj;
import com.soraya.SettingAlarm;
import com.soraya.Tarea;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Date;

public class PantallaPrueba extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox vBox = new VBox();
        Reloj reloj = new Reloj();
        reloj.setFormato24(false);
        Date hora = new Date();
        Tarea tarea = new Tarea("Esta es la tarea", hora);
        reloj.registrarTarea(tarea);

        vBox.getChildren().add(reloj);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
        reloj.comienza();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
