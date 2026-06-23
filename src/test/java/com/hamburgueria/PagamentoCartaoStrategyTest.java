package com.hamburgueria;

import org.example.pagamento.PagamentoCartaoStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes da Strategy: PagamentoCartaoStrategy")
class PagamentoCartaoStrategyTest {

    @Test
    @DisplayName("Deve aplicar corretamente 5% de acréscimo sobre o valor do hambúrguer")
    void deveCalcularTaxaCartao() {
        PagamentoCartaoStrategy cartao = new PagamentoCartaoStrategy();

        double valorFinal = cartao.calcularValorFinal(100.00);

        assertEquals(105.00, valorFinal, 0.001);
    }
}