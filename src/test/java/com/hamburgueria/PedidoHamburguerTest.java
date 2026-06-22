package com.hamburgueria;

import org.example.atendimento.*;
import org.example.cardapio.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes de Integração: PedidoHamburguer (Bridge + State + Observer)")
class PedidoHamburguerTest {

    @Test
    @DisplayName("Deve iniciar o pedido com o estado inicial correto (Recebido)")
    void deveIniciarEmEstadoRecebido() {
        Hamburguer burger = HamburguerFactory.criarHamburguer("CARNE");
        MetodoEntrega entrega = new EntregaLocal();

        PedidoHamburguer pedido = new PedidoHamburguer("Pedro", burger, entrega);

        assertEquals("Recebido (Na Fila)", pedido.getSituacaoAtual());
    }

    @Test
    @DisplayName("Deve avançar o ciclo de vida do pedido com sucesso por todas as etapas")
    void deveAvancarCicloDeVidaComSucesso() {
        Hamburguer burger = HamburguerFactory.criarHamburguer("CARNE");
        MetodoEntrega entrega = new EntregaLocal();
        PedidoHamburguer pedido = new PedidoHamburguer("Pedro", burger, entrega);

        // Adiciona os observadores para garantir que o disparo de notificações não quebra o fluxo
        pedido.anexarObservador(new DisparadorMensagem());
        pedido.anexarObservador(new PainelProducao());

        // 1. Avança de Recebido -> Grelhando
        pedido.avancarEtapa();
        assertEquals("Grelhando (Na Chapa)", pedido.getSituacaoAtual());

        // 2. Avança de Grelhando -> Pronto
        pedido.avancarEtapa();
        assertEquals("Pronto para Entrega/Retirada", pedido.getSituacaoAtual());
    }

    @Test
    @DisplayName("Deve permitir cancelar o pedido quando ele ainda estiver no estado Recebido")
    void devePermitirCancelarEmRecebido() {
        Hamburguer burger = HamburguerFactory.criarHamburguer("VEGANO");
        MetodoEntrega entrega = new EntregaDelivery();
        PedidoHamburguer pedido = new PedidoHamburguer("Pietra", burger, entrega);

        pedido.cancelarPedido();
        assertEquals("Cancelado", pedido.getSituacaoAtual());
    }

    @Test
    @DisplayName("Não deve permitir o cancelamento se o hambúrguer já estiver na chapa (Grelhando)")
    void naoDeveCancelarNaChapa() {
        Hamburguer burger = HamburguerFactory.criarHamburguer("CARNE");
        MetodoEntrega entrega = new EntregaDelivery();
        PedidoHamburguer pedido = new PedidoHamburguer("Pedro", burger, entrega);

        pedido.avancarEtapa(); // Mudou para Grelhando

        IllegalStateException excecao = assertThrows(IllegalStateException.class, () -> {
            pedido.cancelarPedido();
        });

        assertEquals("O burger já está na chapa e não pode ser cancelado sem desperdício!", excecao.getMessage());
        assertEquals("Grelhando (Na Chapa)", pedido.getSituacaoAtual()); // Garante que o estado não mudou
    }

    @Test
    @DisplayName("Não deve permitir avançar ou cancelar um pedido que já está Pronto")
    void naoDeveAlterarPedidoPronto() {
        Hamburguer burger = HamburguerFactory.criarHamburguer("CARNE");
        MetodoEntrega entrega = new EntregaLocal();
        PedidoHamburguer pedido = new PedidoHamburguer("Pedro", burger, entrega);

        pedido.avancarEtapa(); // Grelhando
        pedido.avancarEtapa(); // Pronto

        // Tentar avançar mais uma vez
        assertThrows(IllegalStateException.class, pedido::avancarEtapa);

        // Tentar cancelar depois de pronto
        assertThrows(IllegalStateException.class, pedido::cancelarPedido);
    }

    @Test
    @DisplayName("Deve processar corretamente o texto e os preços integrando a Factory e o Bridge")
    void deveProcessarTextoEPrecoPeloBridge() {
        Hamburguer burger = HamburguerFactory.criarHamburguer("CARNE");
        burger = new BaconDecorator(burger); // 25.00 + 4.50 = 29.50
        MetodoEntrega entrega = new EntregaDelivery();

        PedidoHamburguer pedido = new PedidoHamburguer("Pedro", burger, entrega);

        String resultadoTexto = pedido.processarPedido();

        assertEquals(29.50, pedido.getPrecoTotal(), 0.001);
        assertTrue(resultadoTexto.contains("Pedido de Pedro"));
        assertTrue(resultadoTexto.contains("Preço: R$ 29.5"));
        assertTrue(resultadoTexto.contains("Pedido embalado em caixa térmica para motoboy."));
    }
}