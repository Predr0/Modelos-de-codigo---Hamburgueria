package com.hamburgueria;

import org.example.cardapio.BaconDecorator;
import org.example.cardapio.Hamburguer;
import org.example.cardapio.HamburguerCarne;
import org.example.cardapio.QueijoDecorator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Adicional: QueijoDecorator")
class QueijoDecoratorTest {

    @Test
    @DisplayName("Deve somar o valor do queijo ao hambúrguer base")
    void deveSomarQueijoAoHamburguerBase() {
        Hamburguer burger = new HamburguerCarne();
        burger = new QueijoDecorator(burger);

        assertEquals(28.00, burger.getPreco(), 0.001);
    }

    @Test
    @DisplayName("Deve calcular corretamente a combinação recursiva de múltiplos decorators diferentes")
    void deveCalcularPrecoComVariosDecoratorsDiferentes() {
        Hamburguer burgerCompleto = new HamburguerCarne();
        burgerCompleto = new QueijoDecorator(burgerCompleto);
        burgerCompleto = new BaconDecorator(burgerCompleto);

        assertEquals(32.50, burgerCompleto.getPreco(), 0.001);
    }
}