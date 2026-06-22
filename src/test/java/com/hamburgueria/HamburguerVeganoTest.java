package com.hamburgueria;

import org.example.cardapio.HamburguerVegano;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Produto: HamburguerVegano")
class HamburguerVeganoTest {

    @Test
    @DisplayName("Deve instanciar corretamente e retornar o preço base correto")
    void deveRetornarPrecoBaseCorreto() {
        HamburguerVegano burger = new HamburguerVegano();
        assertEquals(28.00, burger.getPreco(), 0.001);
    }
}