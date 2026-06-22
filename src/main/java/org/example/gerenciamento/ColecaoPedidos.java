package org.example.gerenciamento;

import org.example.atendimento.PedidoHamburguer;
import java.util.ArrayList;
import java.util.List;

public class ColecaoPedidos {
    private final List<PedidoHamburguer> lista = new ArrayList<>();

    public void adicionarPedido(PedidoHamburguer p) {
        lista.add(p);
    }

    public InteradorPedidos criarInterador() {
        return new InteradorListaPedidos();
    }

    // Classe interna que implementa o Iterator mascarando a estrutura da List
    private class InteradorListaPedidos implements InteradorPedidos {
        private int indice = 0;

        @Override
        public boolean temProximo() {
            return indice < lista.size();
        }

        @Override
        public PedidoHamburguer proximo() {
            if (this.temProximo()) {
                return lista.get(indice++);
            }
            return null;
        }
    }
}