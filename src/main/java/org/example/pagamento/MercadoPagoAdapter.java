package org.example.pagamento;

public class MercadoPagoAdapter implements ProcessadorPagamentoTarget {
    private final MercadoPagoSDK sdkMercadoPago;

    public MercadoPagoAdapter(MercadoPagoSDK sdkMercadoPago) {
        this.sdkMercadoPago = sdkMercadoPago;
    }

    @Override
    public void processar(double valor) {
        // Traduz o método do nosso sistema para o método do SDK deles
        this.sdkMercadoPago.enviarCobrançaExterna(valor);
    }
}