package com.hamburgueria;

import org.example.pagamento.PagamentoPixStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes da Strategy: PagamentoPixStrategy")
class PagamentoPixStrategyTest {

    @Test
    @DisplayName("Deve aplicar corretamente 10% de desconto sobre o valor do hambúrguer")
    void deveCalcularDescontoPix() {
        PagamentoPixStrategy pix = new PagamentoPixStrategy();

        double valorFinal = pix.calcularValorFinal(30.00);

        assertEquals(27.00, valorFinal, 0.001);
    }
}