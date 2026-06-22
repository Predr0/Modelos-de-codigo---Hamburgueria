package org.example.auditoria;

import java.util.Stack;

public class HistoricoCaixaCaretaker {
    private final Stack<CaixaMemento> historico = new Stack<>();

    public void salvarEstado(CaixaMemento memento) {
        historico.push(memento);
    }

    public CaixaMemento desfazer() {
        if (!historico.isEmpty()) {
            return historico.pop();
        }
        return null;
    }
}