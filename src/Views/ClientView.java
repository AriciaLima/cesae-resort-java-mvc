package Views;

import Controllers.ClientController;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientView {

    private ClientController clientController;

    public ClientView() throws FileNotFoundException {
        this.clientController = new ClientController();
    }

    public void menu() {

        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n\n***** Menu do Cliente *****");
            System.out.println("1. Consultar Quartos Disponíveis");
            System.out.println("2. Consultar Experiências Disponíveis");
            System.out.println("3. Consultar Experiência Favorita");
            System.out.println("4. Consultar Experiência Top-Seller");
            System.out.println("5. Avaliar uma Experiência");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    consultarQuartos();
                    break;

                case 2:
                    System.out.println("Funcionalidade ainda não implementada.");
                    break;

                case 3:
                    System.out.println("Funcionalidade ainda não implementada.");
                    break;

                case 4:
                    System.out.println("Funcionalidade ainda não implementada.");
                    break;

                case 5:
                    System.out.println("Funcionalidade ainda não implementada.");
                    break;

                case 0:
                    System.out.println("Até à próxima ⍈");
                    break;

                default:
                    System.out.println("❌ Opção Inválida: " + opcao + " ❌");
                    break;
            }

        } while (opcao != 0);
    }

    private void consultarQuartos() {
        ArrayList<String[]> lista = clientController.consultarQuartosDisponiveis();

        System.out.println("\n=== Quartos Disponíveis ===");
        System.out.println("+----------+----------------------+----------+");
        System.out.printf("| %-8s | %-20s | %-8s |\n", "Quarto", "Tipologia", "Preço");
        System.out.println("+----------+----------------------+----------+");

        for (String[] linha : lista) {
            System.out.printf("| %-8s | %-20s | %-8s |\n",
                    linha[0], linha[1], linha[2]);
        }

        System.out.println("+----------+----------------------+----------+");
    }

}

