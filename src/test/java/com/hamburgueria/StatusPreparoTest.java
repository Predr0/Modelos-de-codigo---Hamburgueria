package com.hamburgueria;

import org.example.atendimento.*;
import org.example.cardapio.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Estado: StatusPreparo")
class StatusPreparoTest {

    @Test
    @DisplayName("Deve retornar o nome textual correto do estado na chapa")
    void deveRetornarNomeCorreto() {
        StatusPreparo state = new StatusPreparo();
        assertEquals("Grelhando (Na Chapa)", state.getNomeSituacao());
    }

    @Test
    @DisplayName("Deve lançar exceção ao tentar cancelar um hambúrguer que já está na chapa")
    void deveLancarExcecaoAoCancelarNaChapa() {
        Hamburguer burger = HamburguerFactory.criarHamburguer("CARNE");
        PedidoHamburguer pedido = new PedidoHamburguer("Pedro", burger, new EntregaLocal());
        StatusPreparo state = new StatusPreparo();

        assertThrows(IllegalStateException.class, () -> {
            state.cancelar(pedido);
        });
    }
}