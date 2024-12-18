package com.example.examendilaura;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GestionAforoController {

    public Button inicializarAforoButton;
    public TextField numeroEntrada;
    public Label aforoMaximoL;
    public Label aforoActualL;
    Aforo aforo = null;

    public void initialize(){
        aforo = new Aforo();

    }

    public void onInicializarAforoButtonClick(ActionEvent actionEvent) {
        int aforoMaximo = Integer.parseInt(numeroEntrada.getText());
        numeroEntrada.clear();
        numeroEntrada.setPromptText(String.valueOf(aforoMaximo));
        aforo.setAforoMaximo(aforoMaximo);
        aforoMaximoL.setText(String.valueOf(aforo.getAforoMaximo()));
        aforoActualL.setText(String.valueOf(aforo.getAforoActual()));
        
    }
}