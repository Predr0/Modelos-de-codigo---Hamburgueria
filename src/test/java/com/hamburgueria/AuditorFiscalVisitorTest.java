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
    @DisplayName("Deve visitar o pedido e extrair os dados simulando a fiscalização da Receita")
    void deveVisitarEExtrairDadosFiscais() {
        ByteArrayOutputStream somConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(somConsole));

        Hamburguer burger = HamburguerFactory.criarHamburguer("CARNE");
        PedidoHamburguer pedido = new PedidoHamburguer("Pietra", burger, new EntregaLocal());

        InspetorReceita visitor = new InspetorReceita();
        visitor.visitarPedido(pedido);

        String resultadoLog = somConsole.toString();

        assertTrue(resultadoLog.contains("[RECEITA FEDERAL]"));
        assertTrue(resultadoLog.contains("Cliente associado: Pietra"));

        System.setOut(System.out);
    }
}