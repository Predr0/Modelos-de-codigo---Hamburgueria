package com.hamburgueria;

import org.example.cardapio.Hamburguer;
import org.example.cardapio.HamburguerCarne;
import org.example.cardapio.HamburguerVegano;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Prototype: Clonagem de Hamburgueres")
class HamburguerPrototypeTest {

    @Test
    @DisplayName("Deve clonar um hambúrguer de carne gerando uma nova referência em memória")
    void deveClonarHamburguerCarne() {
        Hamburguer original = new HamburguerCarne();
        Hamburguer clone = original.clonar();

        assertNotNull(clone);
        assertEquals(original.getPreco(), clone.getPreco(), 0.001);
        assertNotSame(original, clone, "O clone não pode apontar para o mesmo endereço de memória!");
    }

    @Test
    @DisplayName("Deve clonar um hambúrguer vegano de forma independente")
    void deveClonarHamburguerVegano() {
        Hamburguer original = new HamburguerVegano();
        Hamburguer clone = original.clonar();

        assertNotNull(clone);
        assertEquals(original.getPreco(), clone.getPreco(), 0.001);
        assertNotSame(original, clone);
    }
}