package org.example.cardapio;

public class QueijoDecorator extends AdicionalDecorator {

    public QueijoDecorator(Hamburguer hamburguerDecorado) {
        super(hamburguerDecorado);
    }

    @Override
    public void preparar() {
        super.preparar();
        System.out.println("-> Adicionando queijo cheddar derretido extra...");
    }

    @Override
    public double getPreco() {
        // Pega o preço do que já existia e soma o valor do queijo
        return super.getPreco() + 3.00;
    }

    @Override
    public Hamburguer clonar() {
        return new QueijoDecorator(this.hamburguerDecorado.clonar());
    }

}