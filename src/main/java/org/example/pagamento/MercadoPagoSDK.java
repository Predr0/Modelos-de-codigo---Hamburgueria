package org.example.pagamento;

public class MercadoPagoSDK {
    public void enviarCobrançaExterna(double quantia) {
        System.out.println("[API MERCADO PAGO] Conectando ao gateway externo... Pago R$ " + quantia);
    }
}