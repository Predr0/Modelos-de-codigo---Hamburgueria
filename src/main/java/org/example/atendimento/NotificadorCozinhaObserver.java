package org.example.atendimento;

public class NotificadorCozinhaObserver implements PedidoObserver {
    @Override
    public void notificar(String nomeCliente, String nomeSituacao) {
        if (nomeSituacao.contains("Recebido")) {
            System.out.println("[PAINEL COZINHA] NOVO PEDIDO: Ligar a chapa para o cliente " + nomeCliente);
        }
    }
}