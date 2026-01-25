package Views;

import Controllers.GuideController;
import Models.Experiencia;

import java.util.ArrayList;
import java.util.Scanner;

public class GuideView {

    private GuideController guideController;
    private String idGuiaLogado;
    private Scanner input;

    // O ID do guia vem diretamente do LoginView
    public GuideView(String idGuiaLogado) {
        this.guideController = new GuideController();
        this.idGuiaLogado = idGuiaLogado;
        this.input = new Scanner(System.in);
    }

    public void menu() {
        int opcao;

        do {
            System.out.println("\n\n***** Bem-vinda, Guia " + idGuiaLogado + " *****");
            System.out.println("1. Consultar Histórico de Experiências");
            System.out.println("0. Voltar");

            System.out.print("Opção: ");
            opcao = input.nextInt();
            input.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    consultarHistorico();
                    break;

                case 0:
                    System.out.println("Até à próxima ⍈");
                    break;

                default:
                    System.out.println("❌ Opção Inválida ❌");
                    break;
            }

        } while (opcao != 0);
    }

    private void consultarHistorico() {

        ArrayList<Experiencia> historico = guideController.getHistorico(idGuiaLogado);

        if (historico.isEmpty()) {
            System.out.println("Nenhuma experiência encontrada para este guia.");
            return;
        }

        System.out.println("\n===== Histórico de Experiências =====");
        for (Experiencia e : historico) {
            System.out.println(
                    "ID: " + e.getId() +
                            " | Nome: " + e.getNome() +
                            " | Preço Adulto: " + e.getPrecoAdulto() +
                            " | Preço Criança: " + e.getPrecoCrianca()
            );
        }
    }
}
