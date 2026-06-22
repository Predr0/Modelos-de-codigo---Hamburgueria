package org.example.auditoria;

import org.example.atendimento.PedidoHamburguer;

public class AuditorFiscalVisitor implements AuditorVisitor {
    @Override
    public void visitarPedido(PedidoHamburguer pedido) {
        System.out.println("[AUDITOR FISCAL VISITOR] Inspecionando Pedido...");
        System.out.println("-> Cliente associado: " + pedido.getNomeCliente());
        System.out.println("-> Valor tributável: R$ " + pedido.getPrecoTotal());
    }
}