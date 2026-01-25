package Views;

import Controllers.StaffController;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StaffView {

    private StaffController staffController;

    public StaffView() throws FileNotFoundException {
        // Cria o controlador
        this.staffController = new StaffController();
    }

    public void menu() {
        Scanner input = new Scanner(System.in);
        int opcao;

        do {

            System.out.println("\n\n***** Bem-vind@ Staff *****");
            System.out.println("1. Consultar Quartos Disponíveis");
            System.out.println("2. Consultar Quartos Reservados");
            System.out.println("3. Consultar Reservas Atuais");
            System.out.println("4. Efetuar uma Reserva");
            System.out.println("5. Reservar uma Experiência");
            System.out.println("0. Voltar");

            System.out.print("Opção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    // Mostra tabela com quartos disponíveis
                    ArrayList<String[]> disponiveis = staffController.quartosDisponiveisSemanaAtual();

                    System.out.println("\n===== Quartos Disponíveis — Semana Atual =====");
                    System.out.println("+------------+----------------------+------------------+");
                    System.out.printf("| %-10s | %-20s | %-16s |\n",
                            "num_quarto", "tipologia", "preco_por_semana");
                    System.out.println("+------------+----------------------+------------------+");

                    if (disponiveis.isEmpty()) {
                        System.out.printf("| %-10s | %-20s | %-16s |\n", "-", "Nenhum disponível", "-");
                    } else {
                        for (String[] row : disponiveis) {
                            System.out.printf("| %-10s | %-20s | %-16s |\n",
                                    row[0].trim(), row[1].trim(), row[2].trim());
                        }
                    }
                    System.out.println("+------------+----------------------+------------------+");
                    break;

                case 2:
                    break;

                case 0:
                    System.out.println("Até à proxima ⍈");
                    break;

                default:
                    System.out.println("❌ Opção Inválida: " + opcao + " ❌");
                    break;
            }
        } while (opcao != 0);
    }
}
