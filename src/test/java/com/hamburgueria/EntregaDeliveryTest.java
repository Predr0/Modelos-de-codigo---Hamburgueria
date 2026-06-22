package com.hamburgueria;

import org.example.atendimento.EntregaDelivery;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Bridge: EntregaDelivery")
class EntregaDeliveryTest {

    @Test
    @DisplayName("Deve retornar a mensagem correta de despacho para motoboy")
    void deveRetornarMensagemDelivery() {
        EntregaDelivery delivery = new EntregaDelivery();
        String mensagem = delivery.prepararEntrega();

        assertEquals("Pedido embalado em caixa térmica para motoboy.", mensagem);
    }
}