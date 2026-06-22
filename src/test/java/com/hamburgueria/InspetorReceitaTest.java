package com.hamburgueria;

import org.example.atendimento.EntregaLocal;
import org.example.atendimento.PedidoHamburguer;
import org.example.auditoria.InspetorReceita;
import org.example.cardapio.Hamburguer;
import org.example.cardapio.HamburguerFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Visitor: InspetorReceita")
class InspetorReceitaTest {

    @Test
    @DisplayName("Deve visitar o pedido e extrair os dados simulando a fiscalização")
    void deveVisitarEExtrairDadosFiscais() {
        ByteArrayOutputStream somConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(somConsole));

        Hamburguer burger = HamburguerFactory.criarHamburguer("CARNE");
        PedidoHamburguer pedido = new PedidoHamburguer("Pietra", burger, new EntregaLocal());

        InspetorReceita visitor = new InspetorReceita();
        visitor.visitarPedido(pedido);

        String resultadoLog = somConsole.toString();


        assertTrue(resultadoLog.contains("[AUDITOR FISCAL VISITOR]"));
        assertTrue(resultadoLog.contains("Cliente associado: Pietra"));
        assertTrue(resultadoLog.contains("Valor tributável: R$ 25.0"));

        System.setOut(System.out);
    }
}