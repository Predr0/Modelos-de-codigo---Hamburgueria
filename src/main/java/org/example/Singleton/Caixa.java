package org.example.singleton;

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
}