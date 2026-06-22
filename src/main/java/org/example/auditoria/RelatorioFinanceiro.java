package org.example.auditoria;

import org.example.singleton.Caixa;

public class RelatorioFinanceiro extends RelatorioTemplate {
    @Override
    protected void imprimirConteudo() {
        System.out.println("Tipo: Fechamento de Faturamento Diário");
        System.out.println("Faturamento Atual Registrado: R$ " + Caixa.getInstancia().getSaldo());
    }
}