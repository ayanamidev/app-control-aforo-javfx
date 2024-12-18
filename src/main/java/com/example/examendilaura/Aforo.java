package com.example.examendilaura;

public class Aforo {
    private int aforoActual;
    private int aforoMaximo;


    public void setAforoMaximo(int aforoMaximo) {
        this.aforoMaximo = aforoMaximo;
        this.aforoActual = aforoMaximo;
    }

    public int getAforoActual() {
        return aforoActual;
    }

    public int getAforoMaximo() {
        return aforoMaximo;
    }
}
