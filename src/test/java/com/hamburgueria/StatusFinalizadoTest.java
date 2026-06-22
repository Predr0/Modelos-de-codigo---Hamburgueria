package com.hamburgueria;

import org.example.atendimento.*;
import org.example.cardapio.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do State: SituacaoProntoState")
class StatusFinalizadoTest {

    @Test
    @DisplayName("Deve retornar o nome textual correto do estado")
    void deveRetornarNomeCorreto() {
        StatusFinalizado state = new StatusFinalizado();
        assertEquals("Pronto para Entrega/Retirada", state.getNomeSituacao());
    }

    @Test
    @DisplayName("Deve bloquear e lançar exceções para qualquer tentativa de avançar ou cancelar após estar pronto")
    void deveBloquearAlteracoesQuandoPronto() {
        Hamburguer burger = HamburguerFactory.criarHamburguer("CARNE");
        PedidoHamburguer pedido = new PedidoHamburguer("Pedro", burger, new EntregaLocal());
        StatusFinalizado state = new StatusFinalizado();

        assertThrows(IllegalStateException.class, () -> state.avancar(pedido));
        assertThrows(IllegalStateException.class, () -> state.cancelar(pedido));
    }
}