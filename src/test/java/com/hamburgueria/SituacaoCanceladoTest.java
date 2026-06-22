package com.hamburgueria;

import org.example.atendimento.*;
import org.example.cardapio.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do State: SituacaoCanceladoState")
class SituacaoCanceladoTest {

    @Test
    @DisplayName("Deve retornar o nome textual correto do estado")
    void deveRetornarNomeCorreto() {
        StatusEstornado state = new StatusEstornado();
        assertEquals("Cancelado", state.getNomeSituacao());
    }

    @Test
    @DisplayName("Deve bloquear e lançar exceções para qualquer tentativa de avançar ou re-cancelar um pedido cancelado")
    void deveBloquearAlteracoesQuandoCancelado() {
        Hamburguer burger = HamburguerFactory.criarHamburguer("CARNE");
        PedidoHamburguer pedido = new PedidoHamburguer("Pedro", burger, new EntregaLocal());
        StatusEstornado state = new StatusEstornado();

        assertThrows(IllegalStateException.class, () -> state.avancar(pedido));
        assertThrows(IllegalStateException.class, () -> state.cancelar(pedido));
    }
}