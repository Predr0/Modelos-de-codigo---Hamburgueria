package com.hamburgueria;

import org.example.atendimento.*;
import org.example.cardapio.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do State: SituacaoRecebidoState")
class SituacaoRecebidoStateTest {

    @Test
    @DisplayName("Deve retornar o nome textual correto do estado")
    void deveRetornarNomeCorreto() {
        StatusNovo state = new StatusNovo();
        assertEquals("Recebido (Na Fila)", state.getNomeSituacao());
    }

    @Test
    @DisplayName("Deve permitir avançar o pedido da fila para a chapa com sucesso")
    void deveAvancarParaGrelhando() {
        Hamburguer burger = HamburguerFactory.criarHamburguer("CARNE");
        PedidoHamburguer pedido = new PedidoHamburguer("Pedro", burger, new EntregaLocal());
        StatusNovo state = new StatusNovo();

        state.avancar(pedido);
        assertEquals("Grelhando (Na Chapa)", pedido.getSituacaoAtual());
    }
}