package org.example.factory;

public class HamburguerFactory {
    public static Hamburguer criarHamburguer(String tipo) {
        if (tipo.equalsIgnoreCase("CARNE")) {
            return new HamburguerCarne();
        } else if (tipo.equalsIgnoreCase("VEGANO")) {
            return new HamburguerVegano();
        }
        throw new IllegalArgumentException("Tipo de hamburguer desconhecido.");
    }
}