package org.example.atendimento;

public class SituacaoCanceladoState implements SituacaoPedidoState {
    @Override
    public void avancar(PedidoHamburguer pedido) {
        throw new IllegalStateException("Pedido cancelado não pode avançar no fluxo.");
    }

    @Override
    public void cancelar(PedidoHamburguer pedido) {
        throw new IllegalStateException("O pedido já está cancelado.");
    }

    @Override
    public String getNomeSituacao() {
        return "Cancelado";
    }
}