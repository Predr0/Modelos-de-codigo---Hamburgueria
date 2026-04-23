package org.example.bridge;

public class EntregaLocal implements MetodoEntrega {
    public String prepararEntrega() {
        return "Pedido colocado na bandeja para consumo no local.";
    }
}