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
    public Button buttonInicializarAforo;
    public Button entraButton;
    public Button saleButton;
    private Aforo aforo;

    public void initialize(){
        aforo = new Aforo();
        numeroEntrada.textProperty().addListener((observable, oldValue, newValue) -> {
            buttonInicializarAforo.setDisable(newValue.trim().isEmpty() || !isNumeric(newValue) );
        });

    }
    private boolean isNumeric(String newValue) {
        try {
            int numero = Integer.parseInt(newValue);
            return aforo.esNumeroValido(numero);

        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void onInicializarAforoButtonClick(ActionEvent actionEvent) {
        aforo = new Aforo();
        int aforoMaximo = Integer.parseInt(numeroEntrada.getText());
        numeroEntrada.clear();
        numeroEntrada.setPromptText(String.valueOf(aforoMaximo));
        aforo.setAforoMaximo(aforoMaximo);
        aforoMaximoL.setText(String.valueOf(aforo.getAforoMaximo()));
        aforoActualL.setText(String.valueOf(aforo.getAforoActual()));
        entraButton.setDisable(false);



    }

    public void onEntraButtonClick(ActionEvent actionEvent) {
        saleButton.setDisable(false);
        aforo.entra();
        aforoActualL.setText(String.valueOf(aforo.getAforoActual()));
        if (aforo.getAforoActual()>=aforo.getAforoMaximo()){
            entraButton.setDisable(true);
        }

    }

    public void onSaleButtonClick(ActionEvent actionEvent) {
        entraButton.setDisable(false);
        aforo.sale();
        aforoActualL.setText(String.valueOf(aforo.getAforoActual()));
        if (aforo.getAforoActual()<=0){
            saleButton.setDisable(true);
        }

    }
}