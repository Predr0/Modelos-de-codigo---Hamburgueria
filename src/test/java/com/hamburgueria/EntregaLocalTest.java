package com.hamburgueria;

import org.example.atendimento.EntregaLocal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Bridge: EntregaLocal")
class EntregaLocalTest {

    @Test
    @DisplayName("Deve retornar a mensagem correta de servir na bandeja")
    void deveRetornarMensagemLocal() {
        EntregaLocal local = new EntregaLocal();
        String mensagem = local.prepararEntrega();

        assertEquals("Pedido colocado na bandeja para consumo no local.", mensagem);
    }
}