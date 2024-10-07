package estacionamento;

import java.util.Random;

public class Estacionamento {
    private double saldo;
    private Ticket ticketAtual;  // um único ticket por vez

    public Estacionamento() {
        this.saldo = 0.0;
    }

    // gera um número aleatório entre 1000 e 9999 para o ticket
    private int gerarNumeroAleatorio() {
        Random random = new Random();
        return random.nextInt(9000) + 1;  // gera um número entre 1 e 9999
    }

    // emite um ticket com número aleatório e valor fixo
    public Ticket emitirTicket() {
        if (ticketAtual == null || ticketAtual.isPago()) {
            int numeroAleatorio = gerarNumeroAleatorio();
            ticketAtual = new Ticket(numeroAleatorio);
            System.out.println("Ticket emitido: #" + ticketAtual.getNumero());
        } else {
            System.out.println("Já existe um ticket em aberto. Pague o ticket #" + ticketAtual.getNumero() + " antes de emitir outro.");
        }
        return ticketAtual;
    }

    // recebe o pagamento do ticket
    public boolean pagarTicket(double valorPago) {
        if (ticketAtual != null && !ticketAtual.isPago()) {
            if (valorPago >= ticketAtual.getValor()) {
                ticketAtual.pagar();
                saldo += ticketAtual.getValor();  // Atualiza o saldo
                System.out.println("Pagamento aceito para o Ticket #" + ticketAtual.getNumero() + "! Troco: R$ " + (valorPago - ticketAtual.getValor()));
                return true;
            } else {
                System.out.println("Pagamento insuficiente! Valor restante: R$ " + (ticketAtual.getValor() - valorPago));
                return false;
            }
        }
        System.out.println("Não há ticket em aberto ou o Ticket #" + (ticketAtual != null ? ticketAtual.getNumero() : "N/A") + " já foi pago.");
        return false;
    }

    // consulta o saldo total arrecadado
    public double consultarSaldo() {
        return saldo;
    }
}
