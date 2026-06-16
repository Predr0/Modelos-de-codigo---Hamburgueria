package org.example.factory;

import org.example.cardapio.Hamburguer;
import org.example.cardapio.HamburguerCarne;
import org.example.cardapio.HamburguerFactory;
import org.example.cardapio.HamburguerVegano;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactoryTest {

    @Test
    void deveCriarHamburguerDeCarne() {
        Hamburguer h = HamburguerFactory.criarHamburguer("CARNE");
        assertTrue(h instanceof HamburguerCarne);
        assertEquals(25.00, h.getPreco());
    }

    @Test
    void deveCriarHamburguerVegano() {
        Hamburguer h = HamburguerFactory.criarHamburguer("VEGANO");
        assertTrue(h instanceof HamburguerVegano);
        assertEquals(28.00, h.getPreco());
    }

    @Test
    void deveLancarExcecaoParaTipoInexistente() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            HamburguerFactory.criarHamburguer("PEIXE");
        });
        assertEquals("Tipo de hamburguer desconhecido.", exception.getMessage());
    }

    @Test
    void deveExecutarPreparoSfereErro() {
        Hamburguer h = HamburguerFactory.criarHamburguer("CARNE");
        assertDoesNotThrow(() -> h.preparar());
    }
}