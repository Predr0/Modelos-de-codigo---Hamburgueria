package com.hamburgueria;

import org.example.singleton.Caixa;
import org.example.auditoria.CaixaMemento;
import org.example.auditoria.HistoricoCaixaCaretaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Memento: CaixaMemento + Caretaker")
class CaixaMementoTest {

    @Test
    @DisplayName("Deve salvar o estado do caixa e restaurar com sucesso simulando um Ctrl+Z")
    void deveSalvarERestaurarEstadoDoCaixa() {
        Caixa caixa = Caixa.getInstancia();
        HistoricoCaixaCaretaker caretaker = new HistoricoCaixaCaretaker();

        caixa.resetarCaixa();
        caixa.registrarVenda(50.00);

        CaixaMemento mementoBackup = caixa.salvarNoMemento();
        caretaker.salvarEstado(mementoBackup);


        caixa.registrarVenda(1000.00);
        assertEquals(1050.00, caixa.getSaldo(), 0.001);

        CaixaMemento mementoRecuperado = caretaker.desfazer();
        assertNotNull(mementoRecuperado);

        caixa.restaurarDoMemento(mementoRecuperado);

        assertEquals(50.00, caixa.getSaldo(), 0.001, "O Memento falhou em restaurar o saldo original do Caixa!");
    }

    @Test
    @DisplayName("Deve retornar nulo se tentar desfazer com o histórico de mementos vazio")
    void deveRetornarNuloComHistoricoVazio() {
        HistoricoCaixaCaretaker caretaker = new HistoricoCaixaCaretaker();
        assertNull(caretaker.desfazer(), "O caretaker deveria retornar null caso não existam backups salvos.");
    }
}