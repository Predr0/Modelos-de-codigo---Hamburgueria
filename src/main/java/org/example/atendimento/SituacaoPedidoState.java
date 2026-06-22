package org.example.atendimento;

public interface SituacaoPedidoState {
    void avancar(PedidoHamburguer pedido);
    void cancelar(PedidoHamburguer pedido);
    String getNomeSituacao();
}