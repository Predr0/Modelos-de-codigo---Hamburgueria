package org.example.pagamento;

public class PagamentoProxy implements ProcessadorPagamentoTarget {
    private final ProcessadorPagamentoTarget processadorReal;

    public PagamentoProxy(ProcessadorPagamentoTarget processadorReal) {
        this.processadorReal = processadorReal;
    }

    @Override
    public void processar(double valor) {
        // Regras de segurança/auditoria antes do pagamento real acontecer
        System.out.println("[PROXY SEGURANÇA] Validando chaves e criptografia da transação... OK.");
        System.out.println("[PROXY AUDITORIA] Log: Tentativa de débito gerada no valor de R$ " + valor);

        // Delega para o processador real (ou para o adaptador)
        this.processadorReal.processar(valor);

        System.out.println("[PROXY AUDITORIA] Log: Transação aprovada e registrada no banco de dados.");
    }
}