package estacionamento;

public class Ticket {
    private int numero;
    private double valor = 5.0;  // valor fixo de R$ 5,00
    private boolean pago;

    public Ticket(int numero) {
        this.numero = numero;
        this.pago = false;  // inicialmente o ticket não está pago
    }

    // retorna o número do ticket
    public int getNumero() {
        return numero;
    }

    // retorna o valor do ticket
    public double getValor() {
        return valor;
    }

    // verifica se o ticket foi pago
    public boolean isPago() {
        return pago;
    }

    // marca o ticket como pago
    public void pagar() {
        this.pago = true;
    }

    @Override
    public String toString() {
        return "Ticket #" + numero + " - Valor: R$ " + valor + " - Pago: " + (pago ? "Sim" : "Não");
    }
}
