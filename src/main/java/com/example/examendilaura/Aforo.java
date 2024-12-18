package com.example.examendilaura;

public class Aforo {
    private int aforoActual=0;
    private int aforoMaximo;


    public void setAforoMaximo(int aforoMaximo) {
        this.aforoMaximo = aforoMaximo;
    }

    public int getAforoActual() {
        return aforoActual;
    }

    public int getAforoMaximo() {
        return aforoMaximo;
    }
    public boolean esNumeroValido(int  numero) {
        return numero > 0 ;
    }

    public void entra() {
        aforoActual++;

    }

    public void sale() {
        aforoActual--;
    }
}
