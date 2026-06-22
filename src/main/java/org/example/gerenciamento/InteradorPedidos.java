package org.example.gerenciamento;

import org.example.atendimento.PedidoHamburguer;

public interface InteradorPedidos {
    boolean temProximo();
    PedidoHamburguer proximo();
}