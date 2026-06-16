package org.example.atendimento;

public abstract class Pedido {
    protected MetodoEntrega metodoEntrega;

    protected Pedido(MetodoEntrega metodoEntrega) {
        this.metodoEntrega = metodoEntrega;
    }

    public abstract String processarPedido();
}