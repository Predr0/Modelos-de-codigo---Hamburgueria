package com.hamburgueria;

import org.example.auditoria.RelatorioFinanceiro;
import org.example.singleton.Caixa;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Template Method: RelatorioFinanceiro")
class RelatorioFinanceiroTest {

    @Test
    @DisplayName("Deve gerar o relatório financeiro contendo o esqueleto padrão e o saldo do caixa")
    void deveGerarRelatorioComEstruturaETextoCorretos() {
        ByteArrayOutputStream somConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(somConsole));

        Caixa.getInstancia().resetarCaixa();
        Caixa.getInstancia().registrarVenda(120.50);

        RelatorioFinanceiro relatorio = new RelatorioFinanceiro();
        relatorio.gerarRelatorio();

        String resultadoLog = somConsole.toString();

        assertTrue(resultadoLog.contains("=== 📊 RELATÓRIO OPERACIONAL HAMBURGUERIA ==="), "Faltou o cabeçalho da classe mãe.");
        assertTrue(resultadoLog.contains("Faturamento Atual Registrado: R$ 120.5"), "Faltou o conteúdo da classe filha.");
        assertTrue(resultadoLog.contains("============================================="), "Faltou o rodapé da classe mãe.");

        System.setOut(System.out);
    }
}