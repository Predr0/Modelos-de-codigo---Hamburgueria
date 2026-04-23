package org.example.bridge;

public class PedidoHamburguer extends Pedido {
    public PedidoHamburguer(MetodoEntrega metodoEntrega) {
        super(metodoEntrega);
    }

    public String processarPedido() {
        return "Hambúrguer pronto. " + metodoEntrega.prepararEntrega();
    }
}