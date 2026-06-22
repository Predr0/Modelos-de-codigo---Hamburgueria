package org.example.atendimento;

public class SituacaoProntoState implements SituacaoPedidoState {
    @Override
    public void avancar(PedidoHamburguer pedido) {
        throw new IllegalStateException("O pedido já está pronto e finalizado.");
    }

    @Override
    public void cancelar(PedidoHamburguer pedido) {
        throw new IllegalStateException("Não é possível cancelar um pedido que já ficou pronto.");
    }

    @Override
    public String getNomeSituacao() {
        return "Pronto para Entrega/Retirada";
    }
}