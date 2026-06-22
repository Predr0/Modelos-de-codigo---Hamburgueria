package org.example;

import org.example.cardapio.*;
import org.example.atendimento.*;
import org.example.singleton.Caixa;
import org.example.pagamento.*;
import org.example.gerenciamento.*;

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
        PedidoHamburguer pedido1 = new PedidoHamburguer("Pedro", meuBurger, entregaMotoboy);

        pedido1.anexarObservador(new PainelProducao());
        pedido1.anexarObservador(new DisparadorMensagem());

        System.out.println("[Status Atual]: " + pedido1.getSituacaoAtual());
        pedido1.anexarObservador((cliente, status) -> {});

        pedido1.avancarEtapa();
        System.out.println("[Status Atual]: " + pedido1.getSituacaoAtual());

        pedido1.avancarEtapa();
        System.out.println("[Status Atual]: " + pedido1.getSituacaoAtual());

        String detalhesEnvio = pedido1.processarPedido();
        System.out.println(detalhesEnvio);
        System.out.println();

        System.out.println("--- 3. Checkout e Pagamento ---");

        double valorPedido = pedido1.getPrecoTotal();

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
        System.out.println();

        System.out.println("--- 5. Gestão de Filas e Clonagem (Iterator + Prototype) ---");

        Hamburguer burgerClonado = ((HamburguerPrototype) meuBurger).clonar();
        PedidoHamburguer pedido2 = new PedidoHamburguer("Pietra", burgerClonado, new EntregaLocal());

        ColecaoPedidos filaDeEspera = new ColecaoPedidos();
        filaDeEspera.adicionarPedido(pedido1);
        filaDeEspera.adicionarPedido(pedido2);

        InteradorPedidos interador = filaDeEspera.criarInterador();
        while (interador.temProximo()) {
            PedidoHamburguer p = interador.proximo();
            System.out.println("Varrendo Fila via Iterator -> Pedido de: " + p.getNomeCliente());
        }
        System.out.println();

        System.out.println("--- 6. Inteligência do Totem (Interpreter) ---");

        ExpressaoTotem interpretador = new ExpressaoPreco();
        String respostaTotem = interpretador.interpretar("Quero saber o preco carne");
        System.out.println("[Totem diz]: " + respostaTotem);

        System.out.println("\n=== 🍔 FIM DO FLUXO DO PEDIDO ===");
    }
}