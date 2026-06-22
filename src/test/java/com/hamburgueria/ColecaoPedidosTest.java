package com.hamburgueria;

import org.example.atendimento.EntregaLocal;
import org.example.atendimento.PedidoHamburguer;
import org.example.cardapio.HamburguerCarne;
import org.example.gerenciamento.ColecaoPedidos;
import org.example.gerenciamento.InteradorPedidos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Iterator: ColecaoPedidos e Interador")
class ColecaoPedidosTest {

    @Test
    @DisplayName("Deve percorrer todos os pedidos inseridos na coleção utilizando o Iterator")
    void devePercorrerPedidosComSucesso() {
        ColecaoPedidos colecao = new ColecaoPedidos();
        PedidoHamburguer p1 = new PedidoHamburguer("Pedro", new HamburguerCarne(), new EntregaLocal());
        PedidoHamburguer p2 = new PedidoHamburguer("Pietra", new HamburguerCarne(), new EntregaLocal());

        colecao.adicionarPedido(p1);
        colecao.adicionarPedido(p2);

        InteradorPedidos interador = colecao.criarInterador();

        assertTrue(interador.temProximo());
        assertEquals(p1, interador.proximo());

        assertTrue(interador.temProximo());
        assertEquals(p2, interador.proximo());

        assertFalse(interador.temProximo());
        assertNull(interador.proximo(), "Chamar proximo() após o fim da lista deve retornar nulo.");
    }

    @Test
    @DisplayName("Deve se comportar corretamente ao tentar iterar sobre uma coleção vazia")
    void deveTratarColecaoVazia() {
        ColecaoPedidos colecao = new ColecaoPedidos();
        InteradorPedidos interador = colecao.criarInterador();

        assertFalse(interador.temProximo());
        assertNull(interador.proximo());
    }
}