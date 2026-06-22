package org.example.atendimento;

import org.example.cardapio.Hamburguer;
import java.util.ArrayList;
import java.util.List;

public class PedidoHamburguer {
    private final String nomeCliente;
    private final Hamburguer hamburguer;
    private final MetodoEntrega metodoEntrega; // Sua interface original do Bridge

    private StatusOrdem situacaoAtual; // O State
    private final List<PedidoObserver> observadores = new ArrayList<>(); // O Observer

    public PedidoHamburguer(String nomeCliente, Hamburguer hamburguer, MetodoEntrega metodoEntrega) {
        this.nomeCliente = nomeCliente;
        this.hamburguer = hamburguer;
        this.metodoEntrega = metodoEntrega;
        this.situacaoAtual = new StatusNovo(); // Inicia recebido
    }

    // Métodos do State
    public void avancarEtapa() {
        this.situacaoAtual.avancar(this);
        this.dispararNotificacoes();
    }

    public void cancelarPedido() {
        this.situacaoAtual.cancelar(this);
        this.dispararNotificacoes();
    }

    protected void setSituacaoInterna(StatusOrdem novaSituacao) {
        this.situacaoAtual = novaSituacao;
    }

    // Métodos do Observer
    public void anexarObservador(PedidoObserver obs) {
        this.observadores.add(obs);
    }

    private void dispararNotificacoes() {
        for (PedidoObserver obs : observadores) {
            obs.notificar(this.nomeCliente, this.situacaoAtual.getNomeSituacao());
        }
    }

    // processando o bridge e atyalizando o modelo do codigo
    public String processarPedido() {
        return "Pedido de " + nomeCliente + ": " +
                "Burger pronto (Preço: R$ " + hamburguer.getPreco() + "). " +
                metodoEntrega.prepararEntrega();
    }

    public String getSituacaoAtual() {
        return this.situacaoAtual.getNomeSituacao();
    }

    public double getPrecoTotal() {
        return this.hamburguer.getPreco();
    }
}