package org.example.pagamento;

public class EfetuarPagamentoCommand implements ComandoPagamento {
    private final ProcessadorPagamentoTarget processador;
    private final double valorFinal;

    public EfetuarPagamentoCommand(ProcessadorPagamentoTarget processador, double valorFinal) {
        this.processador = processador;
        this.valorFinal = valorFinal;
    }

    @Override
    public void executar() {
        // Dispara a ação que foi encapsulada dentro desse comando
        this.processador.processar(valorFinal);
    }
}