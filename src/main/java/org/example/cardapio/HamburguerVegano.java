package org.example.cardapio;

public class HamburguerVegano implements Hamburguer {
    public void preparar() {
        System.out.println("Preparando burger de grão-de-bico...");
    }
    public double getPreco() {
        return 28.00;
    }
    @Override
    public Hamburguer clonar() { return new HamburguerVegano(); }
}