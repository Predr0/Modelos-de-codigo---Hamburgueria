package com.hamburgueria;

import org.example.atendimento.NotificadorClienteObserver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Observer: NotificadorClienteObserver")
class NotificadorClienteObserverTest {

    @Test
    @DisplayName("Deve imprimir mensagem de SMS correta quando o status for Pronto")
    void deveNotificarQuandoPronto() {


        ByteArrayOutputStream somConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(somConsole));

        NotificadorClienteObserver observer = new NotificadorClienteObserver();
        observer.notificar("Pedro", "Pronto para Entrega/Retirada");

        String resultadoLog = somConsole.toString();
        assertTrue(resultadoLog.contains("[SMS CLIENTE]"));
        assertTrue(resultadoLog.contains("Pedro"));
        assertTrue(resultadoLog.contains("PRONTO"));

        System.setOut(System.out); // Restaura o console padrão
    }
}