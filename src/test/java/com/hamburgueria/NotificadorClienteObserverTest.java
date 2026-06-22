package com.hamburgueria;

import org.example.atendimento.DisparadorMensagem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Observer: DisparadorSMS")
class NotificadorClienteObserverTest {

    @Test
    @DisplayName("Deve imprimir mensagem de SMS no console quando o status conter Pronto")
    void deveNotificarQuandoPronto() {
        ByteArrayOutputStream somConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(somConsole));

        DisparadorMensagem observer = new DisparadorMensagem();
        observer.notificar("Pedro", "Pronto para Entrega/Retirada");

        String resultadoLog = somConsole.toString();
        assertTrue(resultadoLog.contains("[NOTIFICAÇÃO TELEFONE]"));
        assertTrue(resultadoLog.contains("Pedro"));

        System.setOut(System.out);
    }
}