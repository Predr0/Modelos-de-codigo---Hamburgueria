package org.example.pagamento;

public class PagamentoProxy implements ProcessadorPagamentoTarget {
    private final ProcessadorPagamentoTarget processadorReal;

    public PagamentoProxy(ProcessadorPagamentoTarget processadorReal) {
        this.processadorReal = processadorReal;
    }

    @Override
    public void processar(double valor) {
        System.out.println("[PROXY SEGURANÇA] Validando chaves e criptografia da transação... OK.");
        System.out.println("[PROXY AUDITORIA] Log: Tentativa de débito gerada no valor de R$ " + valor);

        this.processadorReal.processar(valor);

        System.out.println("[PROXY AUDITORIA] Log: Transação aprovada e registrada no banco de dados.");
    }
}