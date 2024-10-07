package estacionamento;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n1 - Emitir Ticket (R$ 5,00)");
            System.out.println("2 - Pagar Ticket");
            System.out.println("3 - Consultar Saldo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // emitir ticket com valor fixo
                    estacionamento.emitirTicket();
                    break;

                case 2:
                    // receber pagamento do ticket emitido
                    System.out.print("Informe o valor pago: ");
                    double valorPago = scanner.nextDouble();
                    estacionamento.pagarTicket(valorPago);
                    break;

                case 3:
                    // consultar saldo arrecadado
                    System.out.println("Saldo total arrecadado: R$ " + estacionamento.consultarSaldo());
                    break;

                case 0:
                    // encerrar a aplicação
                    System.out.println("Encerrando aplicação...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
