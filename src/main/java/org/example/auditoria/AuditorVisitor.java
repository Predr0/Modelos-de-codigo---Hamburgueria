package org.example.auditoria;

import org.example.atendimento.PedidoHamburguer;

public interface AuditorVisitor {
    void visitarPedido(PedidoHamburguer pedido);
}