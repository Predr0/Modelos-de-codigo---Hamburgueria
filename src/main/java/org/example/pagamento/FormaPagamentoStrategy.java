package org.example.pagamento;

public interface FormaPagamentoStrategy {
    double calcularValorFinal(double valorBase);
}