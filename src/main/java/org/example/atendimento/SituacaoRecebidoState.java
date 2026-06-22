package org.example.atendimento;

public class SituacaoRecebidoState implements SituacaoPedidoState {
    @Override
    public void avancar(PedidoHamburguer pedido) {
        pedido.setSituacaoInterna(new SituacaoGrelhandoState());
    }

    @Override
    public void cancelar(PedidoHamburguer pedido) {
        pedido.setSituacaoInterna(new SituacaoCanceladoState());
    }

    @Override
    public String getNomeSituacao() {
        return "Recebido (Na Fila)";
    }
}