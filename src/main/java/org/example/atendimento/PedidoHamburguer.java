package org.example.atendimento;

import org.example.cardapio.Hamburguer;
import java.util.ArrayList;
import java.util.List;

public class PedidoHamburguer {
    private final String nomeCliente;
    private final Hamburguer hamburguer;
    private final MetodoEntrega metodoEntrega;

    private StatusOrdem situacaoAtual;
    private final List<PedidoObserver> observadores = new ArrayList<>();

    public PedidoHamburguer(String nomeCliente, Hamburguer hamburguer, MetodoEntrega metodoEntrega) {
        this.nomeCliente = nomeCliente;
        this.hamburguer = hamburguer;
        this.metodoEntrega = metodoEntrega;
        this.situacaoAtual = new StatusNovo();
    }

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

    public void anexarObservador(PedidoObserver obs) {
        this.observadores.add(obs);
    }

    private void dispararNotificacoes() {
        for (PedidoObserver obs : observadores) {
            obs.notificar(this.nomeCliente, this.situacaoAtual.getNomeSituacao());
        }
    }

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

    public String getNomeCliente() {
        return this.nomeCliente;
    }
}