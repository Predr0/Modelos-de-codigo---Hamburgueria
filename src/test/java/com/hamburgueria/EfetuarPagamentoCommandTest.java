package com.hamburgueria;

import org.example.pagamento.EfetuarPagamentoCommand;
import org.example.pagamento.ProcessadorPagamentoTarget;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.concurrent.atomic.AtomicBoolean;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Command: EfetuarPagamentoCommand")
class EfetuarPagamentoCommandTest {

    @Test
    @DisplayName("Deve executar a ação de pagamento que foi encapsulada dentro do comando")
    void deveExecutarAcaoDoComando() {
        AtomicBoolean processadorFoiChamado = new AtomicBoolean(false);
        ProcessadorPagamentoTarget processadorMock = valor -> processadorFoiChamado.set(true);

        EfetuarPagamentoCommand comando = new EfetuarPagamentoCommand(processadorMock, 35.00);

        assertFalse(processadorFoiChamado.get(), "Não deve chamar antes do executar.");

        comando.executar();

        assertTrue(processadorFoiChamado.get(), "O Command falhou em invocar o processamento interno ao ser executado.");
    }
}