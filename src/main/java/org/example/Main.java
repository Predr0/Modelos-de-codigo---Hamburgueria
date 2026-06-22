package org.example;

import org.example.cardapio.*;
import org.example.atendimento.*;
import org.example.singleton.Caixa;
import org.example.pagamento.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 🍔 INICIANDO SISTEMA DA HAMBURGUERIA ===\n");

        System.out.println("--- 1. Montagem do Produto ---");

        Hamburguer meuBurger = HamburguerFactory.criarHamburguer("CARNE");

        meuBurger = new QueijoDecorator(meuBurger);
        meuBurger = new BaconDecorator(meuBurger);

        System.out.println("Preço final do Hamburguer customizado: R$ " + meuBurger.getPreco());
        System.out.println();

        System.out.println("--- 2. Fluxo de Atendimento e Cozinha ---");

        MetodoEntrega entregaMotoboy = new EntregaDelivery();

        PedidoHamburguer pedido = new PedidoHamburguer("Pedro", meuBurger, entregaMotoboy);

        pedido.anexarObservador(new NotificadorCozinhaObserver());
        pedido.anexarObservador(new NotificadorClienteObserver());

        System.out.println("[Status Atual]: " + pedido.getSituacaoAtual());
        pedido.anexarObservador((cliente, status) -> {});

        pedido.avancarEtapa();
        System.out.println("[Status Atual]: " + pedido.getSituacaoAtual());

        pedido.avancarEtapa();
        System.out.println("[Status Atual]: " + pedido.getSituacaoAtual());

        String detalhesEnvio = pedido.processarPedido();
        System.out.println(detalhesEnvio);
        System.out.println();

        System.out.println("--- 3. Checkout e Pagamento ---");

        double valorPedido = pedido.getPrecoTotal();

        FormaPagamentoStrategy strategyPix = new PagamentoPixStrategy();
        double valorFinalComDesconto = strategyPix.calcularValorFinal(valorPedido);
        System.out.println("Valor com desconto PIX aplicado: R$ " + valorFinalComDesconto);

        MercadoPagoSDK apiExterna = new MercadoPagoSDK();
        ProcessadorPagamentoTarget adaptador = new MercadoPagoAdapter(apiExterna);

        ProcessadorPagamentoTarget proxySeguro = new PagamentoProxy(adaptador);

        ComandoPagamento acaoPagar = new EfetuarPagamentoCommand(proxySeguro, valorFinalComDesconto);

        acaoPagar.executar();
        System.out.println();

        System.out.println("--- 4. Registro no Caixa da Empresa ---");

        Caixa caixaDaLoja = Caixa.getInstancia();
        caixaDaLoja.registrarVenda(valorFinalComDesconto);

        System.out.println("Saldo Total Acumulado no Caixa da Hamburgueria: R$ " + caixaDaLoja.getSaldo());
        System.out.println("\n=== 🍔 FIM DO FLUXO DO PEDIDO ===");
    }
}