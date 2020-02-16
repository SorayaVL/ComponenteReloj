package com.soraya.test.fxml;

import com.soraya.Reloj;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class PantallaController implements Initializable {
    @FXML
    private Reloj reloj;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        reloj.comienza();

    }
}
