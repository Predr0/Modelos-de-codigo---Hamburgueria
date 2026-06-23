package org.example.pagamento;

public class PagamentoPixStrategy implements FormaPagamentoStrategy {
    @Override
    public double calcularValorFinal(double valorBase) {
        return valorBase * 0.90;
    }
}