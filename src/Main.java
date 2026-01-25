import Views.LoginView;

import java.io.FileNotFoundException;

/**
 * Classe principal da aplicação.
 */
public class Main {

    public static void main(String[] args) {

        try {
            // Inicia o fluxo de login
            LoginView loginView = new LoginView();
            loginView.menu();
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao carregar ficheiros necessários.");
        }
    }
}
