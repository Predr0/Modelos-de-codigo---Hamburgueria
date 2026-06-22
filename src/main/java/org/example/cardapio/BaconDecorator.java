package org.example.cardapio;

public class BaconDecorator extends AdicionalDecorator {

    public BaconDecorator(Hamburguer hamburguerDecorado) {
        super(hamburguerDecorado);
    }

    @Override
    public void preparar() {
        super.preparar();
        System.out.println("-> Adicionando fatias de bacon crocante...");
    }

    @Override
    public double getPreco() {
        // Pega o preço do que já existia e soma o valor do bacon
        return super.getPreco() + 4.50;
    }

    @Override
    public Hamburguer clonar() {
        return new QueijoDecorator(this.hamburguerDecorado.clonar());
    }


}