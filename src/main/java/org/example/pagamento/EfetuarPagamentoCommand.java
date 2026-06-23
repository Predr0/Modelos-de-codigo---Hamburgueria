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
        this.processador.processar(valorFinal);
    }
}