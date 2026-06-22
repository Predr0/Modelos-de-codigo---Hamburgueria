package org.example.atendimento;

public interface PedidoObserver {
    void notificar(String nomeCliente, String nomeSituacao);
}