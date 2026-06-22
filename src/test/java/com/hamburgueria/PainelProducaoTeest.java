package com.hamburgueria;

import org.example.atendimento.PainelProducao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Observer: PainelProducao")
class PainelProducaoTeest {

    @Test
    @DisplayName("Deve imprimir mensagem de SMS correta quando o status for Pronto")
    void deveNotificarQuandoRecebido() {
        ByteArrayOutputStream somConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(somConsole));

        PainelProducao observer = new PainelProducao();
        observer.notificar("Pedro", "Pronto para Entrega/Retirada");

        String resultadoLog = somConsole.toString();
        assertTrue(resultadoLog.contains("[SMS CLIENTE]"));
        assertTrue(resultadoLog.contains("Pedro"));
        assertTrue(resultadoLog.contains("PRONTO"));

        System.setOut(System.out);
    }
}