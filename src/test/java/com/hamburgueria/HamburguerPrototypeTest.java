package com.hamburgueria;

import org.example.cardapio.Hamburguer;
import org.example.cardapio.HamburguerCarne;
import org.example.cardapio.HamburguerVegano;
import org.example.gerenciamento.HamburguerPrototype;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Prototype: Clonagem de Hamburgueres")
class HamburguerPrototypeTest {

    @Test
    @DisplayName("Deve clonar um hambúrguer de carne gerando uma nova referência em memória")
    void deveClonarHamburguerCarne() {
        HamburguerCarne original = new HamburguerCarne();
        Hamburguer clone = (Hamburguer) ((HamburguerPrototype) original).clonar();

        assertNotNull(clone);
        assertEquals(original.getPreco(), clone.getPreco(), 0.001);
        assertNotSame(original, clone, "O clone não pode apontar para o mesmo endereço de memória do original!");
    }

    @Test
    @DisplayName("Deve clonar um hambúrguer vegano de forma independente")
    void deveClonarHamburguerVegano() {
        HamburguerVegano original = new HamburguerVegano();
        Hamburguer clone = (Hamburguer) ((HamburguerPrototype) original).clonar();

        assertNotNull(clone);
        assertEquals(original.getPreco(), clone.getPreco(), 0.001);
        assertNotSame(original, clone);
    }
}