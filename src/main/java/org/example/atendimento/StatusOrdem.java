package org.example.atendimento;

public interface StatusOrdem {
    void avancar(PedidoHamburguer pedido);
    void cancelar(PedidoHamburguer pedido);
    String getNomeSituacao();
}