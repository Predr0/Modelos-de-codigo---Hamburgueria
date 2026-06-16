package org.example.atendimento;

public class PedidoHamburguer extends Pedido {
    public PedidoHamburguer(MetodoEntrega metodoEntrega) {
        super(metodoEntrega);
    }

    public String processarPedido() {
        return "Hambúrguer pronto. " + metodoEntrega.prepararEntrega();
    }
}