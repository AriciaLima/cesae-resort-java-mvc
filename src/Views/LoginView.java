package Views;

import Controllers.LoginController;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginView {

    private LoginController loginController;

    public LoginView() throws FileNotFoundException {
        this.loginController = new LoginController();
    }

    public void menu() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
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

            switch (opcao) {
                case 1: // Cliente
                    ClientView cv = new ClientView();
                    cv.menu();
                    break;

                case 2: // Rececionista
                    menuLogin();
                    break;

                case 3: //Guia de Experiencia
                    break;

                case 4: // Administrador
                    break;

                case 0: // Sair
                    System.out.println("A encerrar ⍈");
                    break;

                default:
                    System.out.println("❌ Opção Inválida: " + opcao + " ❌");
                    break;
            }
        } while (opcao != 0);
    }

    public void menuLogin() throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        String username;
        String password;

        System.out.println("\n\n***** INTERNO *****");
        System.out.print("Username: ");
        username = input.next();
        System.out.print("Password: ");
        password = input.next();

        String accessType = this.loginController.validateLogin(username, password);

        switch (accessType) {
            case "ADMIN":
                AdminView av = new AdminView();
                av.menu();
                break;

            case "FUNC":
                StaffView sv = new StaffView();
                sv.menu();
                break;

            default:
                System.out.println("❌ Credenciais Inválidas ❌");
                break;

        }
    }
}
