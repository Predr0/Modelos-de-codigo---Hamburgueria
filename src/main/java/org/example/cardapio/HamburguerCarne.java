package org.example.cardapio;

public class HamburguerCarne implements Hamburguer {
    public void preparar() {
        System.out.println("Grelando carne bovina 180g...");
    }
    public double getPreco() {
        return 25.00;
    }
    @Override
    public Hamburguer clonar() { return new HamburguerCarne(); }
}