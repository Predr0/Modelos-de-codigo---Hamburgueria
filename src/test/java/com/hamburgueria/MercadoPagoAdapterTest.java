package com.hamburgueria;

import org.example.pagamento.MercadoPagoAdapter;
import org.example.pagamento.MercadoPagoSDK;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Adapter: MercadoPagoAdapter")
class MercadoPagoAdapterTest {

    @Test
    @DisplayName("Deve adaptar e executar o método da API externa do Mercado Pago com sucesso")
    void deveAdaptarMetodoExterno() {
        ByteArrayOutputStream somConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(somConsole));

        MercadoPagoSDK sdkFicticio = new MercadoPagoSDK();
        MercadoPagoAdapter adaptador = new MercadoPagoAdapter(sdkFicticio);

        // Dispara o método do nosso sistema
        adaptador.processar(50.00);

        String resultadoLog = somConsole.toString();

        assertTrue(resultadoLog.contains("[API MERCADO PAGO]"));
        assertTrue(resultadoLog.contains("Pago R$ 50.0"));

        System.setOut(System.out);
    }
}