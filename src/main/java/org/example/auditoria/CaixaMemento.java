package org.example.auditoria;

public class CaixaMemento {
    private final double saldoSalvo;

    public CaixaMemento(double saldo) {
        this.saldoSalvo = saldo;
    }

    public double getSaldoSalvo() {
        return saldoSalvo;
    }
}