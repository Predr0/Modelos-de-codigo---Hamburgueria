package com.hamburgueria;

import org.example.atendimento.*;
import org.example.cardapio.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do State: SituacaoCanceladoState")
class SituacaoCanceladoStateTest {

    @Test
    @DisplayName("Deve retornar o nome textual correto do estado")
    void deveRetornarNomeCorreto() {
        SituacaoCanceladoState state = new SituacaoCanceladoState();
        assertEquals("Cancelado", state.getNomeSituacao());
    }

    @Test
    @DisplayName("Deve bloquear e lançar exceções para qualquer tentativa de avançar ou re-cancelar um pedido cancelado")
    void deveBloquearAlteracoesQuandoCancelado() {
        Hamburguer burger = HamburguerFactory.criarHamburguer("CARNE");
        PedidoHamburguer pedido = new PedidoHamburguer("Pedro", burger, new EntregaLocal());
        SituacaoCanceladoState state = new SituacaoCanceladoState();

        assertThrows(IllegalStateException.class, () -> state.avancar(pedido));
        assertThrows(IllegalStateException.class, () -> state.cancelar(pedido));
    }
}