package org.example.cardapio;

public interface Hamburguer {
    void preparar();
    double getPreco();

    Hamburguer clonar();
}