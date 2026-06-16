package org.example.cardapio;

public abstract class AdicionalDecorator implements Hamburguer {
    protected final Hamburguer hamburguerDecorado;

    public AdicionalDecorator(Hamburguer hamburguerDecorado) {
        this.hamburguerDecorado = hamburguerDecorado;
    }

    @Override
    public void preparar() {
        // Delega o preparo da base antes de colocar o adicional
        this.hamburguerDecorado.preparar();
    }

    @Override
    public double getPreco() {
        // Delega o cálculo do preço acumulado até o momento
        return this.hamburguerDecorado.getPreco();
    }
}