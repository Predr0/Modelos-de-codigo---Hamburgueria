package org.example.singleton;

import org.example.auditoria.CaixaMemento;

public class Caixa {
    private static Caixa instancia;
    private double saldo;

    private Caixa() {
        this.saldo = 0.0;
    }

    public static synchronized Caixa getInstancia() {
        if (instancia == null) {
            instancia = new Caixa();
        }
        return instancia;
    }

    public void registrarVenda(double valor) {
        this.saldo += valor;
    }

    public double getSaldo() {
        return saldo;
    }

    public void resetarCaixa() {
        this.saldo = 0.0;
    }

    // OS DOIS MÉTODOS DEVEM FICAR AQUI:
    public CaixaMemento salvarNoMemento() {
        return new CaixaMemento(this.saldo);
    }

    public void restaurarDoMemento(CaixaMemento memento) {
        if (memento != null) {
            this.saldo = memento.getSaldoSalvo();
        }
    }
}