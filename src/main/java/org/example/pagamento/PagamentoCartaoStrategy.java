package org.example.pagamento;

public class PagamentoCartaoStrategy implements FormaPagamentoStrategy {
    @Override
    public double calcularValorFinal(double valorBase) {
        return valorBase * 1.05;
    }
}