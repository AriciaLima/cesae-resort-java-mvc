package Views;

import Controllers.AdminController;
import Models.Tipologia;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdminView {

    private AdminController adminController;

    public AdminView() throws FileNotFoundException {
        this.adminController = new AdminController();
    }

    public void menu() {

        Scanner input = new Scanner(System.in);
        int opcao;
        do {

            System.out.println("\n\n***** Bem-vind@ Exmo. Admin *****");
            System.out.println("1. Consultar Total de Reservas");
            System.out.println("2. Consultar Total de Receitas");
            System.out.println("3. Consultar Reservas/Receitas Mensais");
            System.out.println("4. Consultar Tipologia de Quarto Mais Reservada");
            System.out.println("5. Consultar Experiência Mais Procurada (Adultos)");
            System.out.println("6. Consultar Experiência Mais Procurada (Crianças)");
            System.out.println("7.Consultar Experiência Mais Lucrativa – Valor total arrecadado");
            System.out.println("8. Consultar Experiência Menos Lucrativa – Valor total arrecadado");
            System.out.println("9. Consultar Quarto com Melhor Preço/Semana");
            System.out.println("10.Adicionar Novo Login\n");
            System.out.println("0. Voltar");

            System.out.print("Opção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1: // Consultar Total de Reservas: Número total de reservas (passadas e futuras)
                    break;

                case 2: // Consultar Total de Receitas: Soma de preco_por_semana (quartos) + preços de bilhetes (experiências)
                    break;

                case 3: // Consultar Reservas/Receitas Mensais: Pergunta ano e mês, e apresenta as receitas desse mês
                    break;

                case 4: // Consultar Tipologia de Quarto Mais Reservada
                    Tipologia t = adminController.tipologiaMaisReservada();
                    System.out.println("Tipologia de Quarto Mais Reservada: " + t.getDescricao());
                    break;

                case 5: //Consultar Experiência Mais Procurada (Adultos) – Número de bilhetes vendidos
                    break;

                case 6: // Consultar Experiência Mais Procurada (Crianças) – Número de bilhetes vendidos
                    break;

                case 7: //Consultar Experiência Mais Lucrativa – Valor total arrecadado
                    break;

                case 8: //Consultar Experiência Menos Lucrativa – Valor total arrecadado
                    break;

                case 9: //Consultar Quarto com Melhor Preço/Semana
                    break;

                case 10: //Adicionar Novo Login
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