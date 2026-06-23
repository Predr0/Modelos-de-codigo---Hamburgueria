package com.hamburgueria;

import org.example.atendimento.DisparadorMensagem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Observer: DisparadorMensagem")
class DisparadorMensagemTest {

    @Test
    @DisplayName("Deve imprimir mensagem no monitor da cozinha quando o status for Recebido")
    void deveNotificarQuandoPronto() {
        ByteArrayOutputStream somConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(somConsole));

        DisparadorMensagem observer = new DisparadorMensagem();

        observer.notificar("Pedro", "Recebido (Na Fila)");

        String resultadoLog = somConsole.toString();
        assertTrue(resultadoLog.contains("[PAINEL COZINHA]"));
        assertTrue(resultadoLog.contains("Pedro"));

        System.setOut(System.out);
    }
}