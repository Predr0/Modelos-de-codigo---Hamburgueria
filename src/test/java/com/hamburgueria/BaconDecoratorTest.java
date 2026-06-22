package com.hamburgueria;

import org.example.cardapio.BaconDecorator;
import org.example.cardapio.Hamburguer;
import org.example.cardapio.HamburguerCarne;
import org.example.cardapio.HamburguerVegano;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Adicional: BaconDecorator")
class BaconDecoratorTest {

    @Test
    @DisplayName("Deve somar o valor do bacon ao hambúrguer de carne base")
    void deveSomarBaconAoHamburguerCarne() {
        Hamburguer burger = new HamburguerCarne(); // R$ 25,00
        burger = new BaconDecorator(burger); // + R$ 4,50

        assertEquals(29.50, burger.getPreco(), 0.001);
    }

    @Test
    @DisplayName("Deve permitir e calcular corretamente o acúmulo de porções duplas de bacon")
    void deveCalcularDuploBacon() {
        Hamburguer burger = new HamburguerVegano(); // R$ 28,00
        burger = new BaconDecorator(burger); // + R$ 4,50
        burger = new BaconDecorator(burger); // + R$ 4,50

        assertEquals(37.00, burger.getPreco(), 0.001);
    }
}