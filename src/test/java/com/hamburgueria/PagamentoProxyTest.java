package com.hamburgueria;

import org.example.pagamento.PagamentoProxy;
import org.example.pagamento.ProcessadorPagamentoTarget;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Proxy: PagamentoProxy")
class PagamentoProxyTest {

    @Test
    @DisplayName("Deve interceptar transação gerando logs de segurança antes de efetuar o pagamento real")
    void deveIntercetarEGerarLogs() {
        ByteArrayOutputStream somConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(somConsole));

        // Criamos um processador anônimo ultra simples só para ver se o proxy chama ele no fim
        ProcessadorPagamentoTarget processadorReal = valor -> System.out.println("Pagamento Real Efetuado: " + valor);
        PagamentoProxy proxy = new PagamentoProxy(processadorReal);

        proxy.processar(45.00);

        String resultadoLog = somConsole.toString();

        // Verifica se o Proxy executou as suas funções de auditoria e segurança
        assertTrue(resultadoLog.contains("[PROXY SEGURANÇA]"));
        assertTrue(resultadoLog.contains("[PROXY AUDITORIA] Log: Tentativa de débito gerada"));
        assertTrue(resultadoLog.contains("Pagamento Real Efetuado: 45.0"));

        System.setOut(System.out);
    }
}