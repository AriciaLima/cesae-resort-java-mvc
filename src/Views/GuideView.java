package Views;

import Controllers.GuideController;

import java.util.Scanner;

public class GuideView {
    private GuideController guideController;

    public GuideView() {
        this.guideController = new GuideController();
    }

    public void menu() {
        Scanner input = new Scanner(System.in);
        int opcao;

        do {

            System.out.println("\n\n***** Bem-vind@, não demores muito, há trabalho para fazer *****");
            System.out.println("1. Consultar Quartos Disponíveis");
            System.out.println("0. Voltar");

            System.out.print("Opção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1: // Consultar Histórico de Experiências
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
