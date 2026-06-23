package org.example.cardapio;

public abstract class AdicionalDecorator implements Hamburguer {
    protected final Hamburguer hamburguerDecorado;

    public AdicionalDecorator(Hamburguer hamburguerDecorado) {
        this.hamburguerDecorado = hamburguerDecorado;
    }

    @Override
    public void preparar() {
        this.hamburguerDecorado.preparar();
    }

    @Override
    public double getPreco() {
        return this.hamburguerDecorado.getPreco();
    }
}