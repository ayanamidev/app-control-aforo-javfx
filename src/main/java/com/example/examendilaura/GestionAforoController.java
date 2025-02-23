package com.example.examendilaura;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class GestionAforoController {

    public Button inicializarAforoButton;
    public TextField numeroEntrada;
    public Label aforoMaximoL;
    public Label aforoActualL;
    public Button buttonInicializarAforo;
    public Button entraButton;
    public Button saleButton;
    public VBox rootVBox;
    public Label labelAforoActual;
    private Aforo aforo;

    public void initialize(){
        rootVBox.setStyle("-fx-background-color: #C0C0C0;");
        aforo = new Aforo();
        buttonInicializarAforo.setDisable(true);
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
        alertar();
        if (aforo.getAforoActual()>=aforo.getAforoMaximo()){
            entraButton.setDisable(true);
        }

    }

    private void alertar() {
        float num = 0.85F;
        int umbral = Math.round(aforo.getAforoMaximo()*num);
        if (aforo.getAforoActual()>=umbral){
            aforoActualL.setStyle("-fx-text-fill: #FF0000;-fx-font-weight: bold;-fx-font-size: 15px;-fx-font-size: 50px;");
            aforoMaximoL.setStyle("-fx-text-fill: #FF0000;-fx-font-weight: bold;-fx-font-size: 50px;");

        }else {
            aforoActualL.setStyle("-fx-text-fill: #000000;-fx-font-weight:normal;-fx-font-size: 15px;-fx-font-size: 50px;");
            aforoMaximoL.setStyle("-fx-text-fill: #000000;-fx-font-weight:normal;-fx-font-size: 50px;");

        }
    }

    public void onSaleButtonClick(ActionEvent actionEvent) {
        entraButton.setDisable(false);
        aforo.sale();
        aforoActualL.setText(String.valueOf(aforo.getAforoActual()));
        alertar();
        if (aforo.getAforoActual()<=0){
            saleButton.setDisable(true);
        }


    }
}