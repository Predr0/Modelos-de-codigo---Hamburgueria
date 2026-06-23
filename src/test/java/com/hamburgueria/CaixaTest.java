package com.hamburgueria;

import org.example.singleton.Caixa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Singleton: Caixa")
class CaixaTest {

    @BeforeEach
    void setUp() {
        Caixa.getInstancia().resetarCaixa();
    }

    @Test
    @DisplayName("Deve garantir que múltiplas chamadas retornem exatamente a mesma instância na memória")
    void deveGarantirInstanciaUnica() {
        Caixa primeiraChamada = Caixa.getInstancia();
        Caixa segundaChamada = Caixa.getInstancia();

        assertNotNull(primeiraChamada, "A instância não deveria ser nula.");

        assertSame(primeiraChamada, segundaChamada, "O Singleton falhou! As instâncias na memória são diferentes.");
    }

    @Test
    @DisplayName("Deve registrar vendas e acumular o saldo do caixa corretamente")
    void deveRegistrarVendasEAcumularSaldo() {
        Caixa caixa = Caixa.getInstancia();

        caixa.registrarVenda(25.00);
        caixa.registrarVenda(32.50);

        assertEquals(57.50, caixa.getSaldo(), 0.001, "O saldo acumulado do caixa deveria ser R$ 57,50.");
    }

    @Test
    @DisplayName("Deve resetar o saldo do caixa para zero com sucesso")
    void deveResetarCaixa() {
        Caixa caixa = Caixa.getInstancia();
        caixa.registrarVenda(150.00);

        caixa.resetarCaixa();

        assertEquals(0.0, caixa.getSaldo(), 0.001, "Após resetar, o saldo do caixa deve ser obrigatoriamente R$ 0,00.");
    }
}