package org.example.bridge;

import org.example.atendimento.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BridgeTest {

    @Test
    void deveProcessarPedidoParaLocal() {
        MetodoEntrega local = new EntregaLocal();
        Pedido pedido = new PedidoHamburguer(local);

        String resultado = pedido.processarPedido();

        assertTrue(resultado.contains("bandeja"));
        assertTrue(resultado.contains("local"));
    }

    @Test
    void deveProcessarPedidoParaDelivery() {
        MetodoEntrega delivery = new EntregaDelivery();
        Pedido pedido = new PedidoHamburguer(delivery);

        String resultado = pedido.processarPedido();

        assertTrue(resultado.contains("caixa térmica"));
        assertTrue(resultado.contains("motoboy"));
    }
}