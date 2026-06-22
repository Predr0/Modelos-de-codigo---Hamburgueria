package com.hamburgueria;

import org.example.atendimento.NotificadorCozinhaObserver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Observer: NotificadorCozinhaObserver")
class NotificadorCozinhaObserverTest {

    @Test
    @DisplayName("Deve imprimir mensagem no painel da cozinha quando o status for Recebido")
    void deveNotificarQuandoRecebido() {
        ByteArrayOutputStream somConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(somConsole));

        NotificadorCozinhaObserver observer = new NotificadorCozinhaObserver();
        observer.notificar("Pedro", "Recebido (Na Fila)");

        String resultadoLog = somConsole.toString();
        assertTrue(resultadoLog.contains("[PAINEL COZINHA]"));
        assertTrue(resultadoLog.contains("Pedro"));
        assertTrue(resultadoLog.contains("Ligar a chapa"));

        System.setOut(System.out); // Restaura o console padrão
    }
}