package com.hamburgueria;

import org.example.cardapio.HamburguerCarne;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Produto: HamburguerCarne")
class HamburguerCarneTest {

    @Test
    @DisplayName("Deve instanciar corretamente e retornar o preço base correto")
    void deveRetornarPrecoBaseCorreto() {
        HamburguerCarne burger = new HamburguerCarne();
        assertEquals(25.00, burger.getPreco(), 0.001);
    }
}