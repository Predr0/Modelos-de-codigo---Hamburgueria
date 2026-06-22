package org.example.atendimento;

public class StatusNovo implements StatusOrdem {
    @Override
    public void avancar(PedidoHamburguer pedido) {
        pedido.setSituacaoInterna(new StatusPreparo());
    }

    @Override
    public void cancelar(PedidoHamburguer pedido) {
        pedido.setSituacaoInterna(new StatusEstornado());
    }

    @Override
    public String getNomeSituacao() {
        return "Recebido (Na Fila)";
    }
}