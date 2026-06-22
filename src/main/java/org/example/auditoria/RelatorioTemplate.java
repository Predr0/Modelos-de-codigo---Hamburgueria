package org.example.auditoria;

public abstract class RelatorioTemplate {
    public final void gerarRelatorio() {
        abrirCabecalho();
        imprimirConteudo();
        fecharRodape();
    }

    private void abrirCabecalho() {
        System.out.println("=== 📊 RELATÓRIO OPERACIONAL HAMBURGUERIA ===");
        System.out.println("Status do Sistema: Autenticado e Seguro");
    }

    protected abstract void imprimirConteudo();

    private void fecharRodape() {
        System.out.println("=============================================");
    }
}