package Views;

import Controllers.StaffController;

import java.util.Scanner;

public class StaffView {

    private StaffController staffController;

    public StaffView() {
        this.staffController = new StaffController();
    }

    public void menu() {
        Scanner input = new Scanner(System.in);
        int opcao;

        do {

            System.out.println("\n\n***** Bem-vind@, não demores muito, há trabalho para fazer *****");
            System.out.println("1. Consultar Quartos Disponíveis");
            System.out.println("2.Consultar Quartos Reservados");
            System.out.println("3. Consultar Reservas Atuais");
            System.out.println("4. Efetuar uma Reserva");
            System.out.println("5. Reservar uma Experiência");
            System.out.println("0. Voltar");

            System.out.print("Opção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1: // Adicionar Nova Venda
                    break;

                case 2: // Consultar Stock
                    break;

                case 0: // Voltar
                    System.out.println("Até à proxima ⍈");
                    break;

                default:
                    System.out.println("❌ Opção Inválida: " + opcao + " ❌");
                    break;
            }
        } while (opcao != 0);

    }
}
