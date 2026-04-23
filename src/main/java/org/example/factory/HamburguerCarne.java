package org.example.factory;

public class HamburguerCarne implements Hamburguer {
    public void preparar() {
        System.out.println("Grelando carne bovina 180g...");
    }
    public double getPreco() {
        return 25.00;
    }
}