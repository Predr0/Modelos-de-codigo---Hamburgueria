package org.example.gerenciamento;

import org.example.cardapio.HamburguerFactory;

public class ExpressaoPreco implements ExpressaoTotem {
    @Override
    public String interpretar(String contexto) {
        if (contexto.toUpperCase().contains("PRECO")) {
            if (contexto.toUpperCase().contains("CARNE")) {
                return "O preço atual do Hamburguer de Carne é R$ " + HamburguerFactory.criarHamburguer("CARNE").getPreco();
            } else if (contexto.toUpperCase().contains("VEGANO")) {
                return "O preço atual do Hamburguer Vegano é R$ " + HamburguerFactory.criarHamburguer("VEGANO").getPreco();
            }
            return "Por favor, especifique o produto (CARNE ou VEGANO).";
        }
        return "Comando não reconhecido pelo Totem.";
    }
}