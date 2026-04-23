package org.example.Singleton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CaixaTest {

    @BeforeEach
    void setup() {
        Caixa.getInstancia().resetarCaixa();
    }

    @Test
    void deveRetornarMesmaInstancia() {
        Caixa c1 = Caixa.getInstancia();
        Caixa c2 = Caixa.getInstancia();
        assertSame(c1, c2);
    }

    @Test
    void deveAcumularSaldoCorretamente() {
        Caixa caixa = Caixa.getInstancia();
        caixa.registrarVenda(50.0);
        caixa.registrarVenda(25.5);
        assertEquals(75.5, caixa.getSaldo());
    }

    @Test
    void instanciaNaoDeveSerNula() {
        assertNotNull(Caixa.getInstancia());
    }
}