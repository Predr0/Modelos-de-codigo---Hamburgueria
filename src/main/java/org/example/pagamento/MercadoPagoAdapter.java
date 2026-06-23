package org.example.pagamento;

public class MercadoPagoAdapter implements ProcessadorPagamentoTarget {
    private final MercadoPagoSDK sdkMercadoPago;

    public MercadoPagoAdapter(MercadoPagoSDK sdkMercadoPago) {
        this.sdkMercadoPago = sdkMercadoPago;
    }

    @Override
    public void processar(double valor) {
        this.sdkMercadoPago.enviarCobrançaExterna(valor);
    }
}