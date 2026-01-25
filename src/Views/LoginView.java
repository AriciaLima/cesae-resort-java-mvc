package Views;

import Controllers.LoginController;
import Enums.Role;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginView {

    private LoginController loginController;
    private Scanner input;

    public LoginView() throws FileNotFoundException {
        this.loginController = new LoginController();
        this.input = new Scanner(System.in);
    }

    public void menu() throws FileNotFoundException {
        int opcao;

        do {
            System.out.println("\n\n***** CESAE Resort – Hotel Temático da Programação © *****");
            System.out.println("1. Cliente");
            System.out.println("2. Rececionista");
            System.out.println("3. Guia de Experiencia");
            System.out.println("4. Administrador");
            System.out.println("0. Sair");

            System.out.print("Opção: ");
            opcao = input.nextInt();
            input.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    new ClientView().menu();
                    break;

                case 2:
                    menuLogin(Role.GESTAO);
                    break;

                case 3:
                    menuLogin(Role.GUIA);
                    break;

                case 4:
                    menuLogin(Role.ADMIN);
                    break;

                case 0:
                    System.out.println("A encerrar ⍈");
                    break;

                default:
                    System.out.println("❌ Opção Inválida ❌");
            }

        } while (opcao != 0);
    }

    public void menuLogin(Role expectedRole) throws FileNotFoundException {

        while (true) {
            System.out.print("Username (0 para voltar): ");
            String username = input.nextLine();

            if (username.equals("0")) return;

            System.out.print("Password: ");
            String password = input.nextLine();

            Role role = loginController.validateLogin(username, password);

            if (role == expectedRole) {
                abrirMenu(role, username); // passa o username
                return;
            } else {
                System.out.println("❌ Acesso não autorizado ❌");
            }
        }
    }

    private void abrirMenu(Role role, String username) throws FileNotFoundException {

        switch (role) {
            case ADMIN:
                new AdminView().menu();
                break;

            case GESTAO:
                new StaffView().menu();
                break;

            case GUIA:
                new GuideView(username).menu(); // passa o ID do guia logado
                break;
        }
    }
}
