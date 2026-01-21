package Views;

import Controllers.ClientController;

import java.util.Scanner;

public class ClientView {

    private ClientController clientController;

    public ClientView() {
        this.clientController = new ClientController();
    }

    public void menu() {

        Scanner input = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n\n***** Bem-vind@ estimado cliente *****");
            System.out.println("1. Consultar Quartos Disponíveis: Imprime em formato tabelar num_quarto, tipologia, preco_por_semana.");
            System.out.println("2.Consultar Experiências Disponíveis: Imprime em formato tabelar, nome, rating_experiencia, nome do guia, \n" +
                    "rating_guia, preco_adulto, preco_crianca.");
            System.out.println("3.Consultar Experiência Favorita: Indica a experiência com melhor rating");
            System.out.println("4. Consultar Experiência Top-Seller: Indica a experiência com mais bilhetes vendidos");
            System.out.println("5. Avaliar uma Experiência: Permite escolher uma experiência, seguidamente, pergunta o rating da experiência e o \n" +
                    "rating do guia.");
            System.out.println("0. Voltar");

            System.out.print("Opção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1: // Consultar Quartos Disponíveis: Imprime em formato tabelar num_quarto, tipologia, preco_por_semana
                    break;

                case 2: //  Consultar Experiências Disponíveis: Imprime em formato tabelar, nome, rating_experiencia, nome do guia, rating_guia, preco_adulto, preco_crianca.
                    break;

                case 3: // Consultar Experiência Favorita: Indica a experiência com melhor rating
                    break;

                case 4: //Consultar Experiência Top-Seller: Indica a experiência com mais bilhetes vendidos
                    break;

                case 5: //Avaliar uma Experiência: Permite escolher uma experiência, seguidamente, pergunta o rating da experiência e o rating do guia.
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
