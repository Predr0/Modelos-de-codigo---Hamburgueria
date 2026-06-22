package org.example.atendimento;

public class PainelProducao implements PedidoObserver {
    @Override
    public void notificar(String nomeCliente, String nomeSituacao) {
        if (nomeSituacao.contains("Pronto")) {
            System.out.println("[SMS CLIENTE] Olá " + nomeCliente + ", seu smash burger está PRONTO e quentinho!");
        }
    }
}