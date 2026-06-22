package org.example.atendimento;

public class SituacaoGrelhandoState implements SituacaoPedidoState {
    @Override
    public void avancar(PedidoHamburguer pedido) {
        pedido.setSituacaoInterna(new SituacaoProntoState());
    }

    @Override
    public void cancelar(PedidoHamburguer pedido) {
        throw new IllegalStateException("O burger já está na chapa e não pode ser cancelado sem desperdício!");
    }

    @Override
    public String getNomeSituacao() {
        return "Grelhando (Na Chapa)";
    }
}