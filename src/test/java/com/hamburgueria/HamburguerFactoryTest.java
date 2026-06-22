package com.hamburgueria;

import org.example.cardapio.Hamburguer;
import org.example.cardapio.HamburguerCarne;
import org.example.cardapio.HamburguerFactory;
import org.example.cardapio.HamburguerVegano;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes da Fábrica: HamburguerFactory")
class HamburguerFactoryTest {

    @Test
    @DisplayName("Deve criar com sucesso um hambúrguer do tipo Carne")
    void deveCriarHamburguerCarne() {
        Hamburguer burger = HamburguerFactory.criarHamburguer("CARNE");

        assertNotNull(burger, "O objeto retornado não deveria ser nulo.");
        assertTrue(burger instanceof HamburguerCarne, "Deveria ser uma instância de HamburguerCarne.");
        assertEquals(25.00, burger.getPreco(), 0.001, "O preço base do hambúrguer de carne deve ser R$ 25,00.");
    }

    @Test
    @DisplayName("Deve criar com sucesso um hambúrguer do tipo Vegano")
    void deveCriarHamburguerVegano() {
        Hamburguer burger = HamburguerFactory.criarHamburguer("VEGANO");

        assertNotNull(burger, "O objeto retornado não deveria ser nulo.");
        assertTrue(burger instanceof HamburguerVegano, "Deveria ser uma instância de HamburguerVegano.");
        assertEquals(28.00, burger.getPreco(), 0.001, "O preço base do hambúrguer vegano deve ser R$ 28,00.");
    }

    @Test
    @DisplayName("Deve ser insensível a maiúsculas/minúsculas ao criar hambúrguer")
    void deveCriarIndependentementeDeCase() {
        Hamburguer burgerMinisculo = HamburguerFactory.criarHamburguer("carne");
        Hamburguer burgerMisturado = HamburguerFactory.criarHamburguer("VeGaNo");

        assertNotNull(burgerMinisculo);
        assertNotNull(burgerMisturado);
        assertEquals(25.00, burgerMinisculo.getPreco(), 0.001);
        assertEquals(28.00, burgerMisturado.getPreco(), 0.001);
    }

    @Test
    @DisplayName("Deve lançar IllegalArgumentException ao passar um tipo desconhecido")
    void deveLancarExcecaoParaTipoInvalido() {
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> {
            HamburguerFactory.criarHamburguer("FRANGO");
        });

        assertEquals("Tipo de hamburguer desconhecido.", excecao.getMessage(), "A mensagem da exceção deve ser idêntica à configurada na Factory.");
    }
}