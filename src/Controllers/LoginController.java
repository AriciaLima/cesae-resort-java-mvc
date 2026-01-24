package Controllers;

import Enums.Role;
import Models.Login;
import Repositories.LoginRepository;

import java.io.FileNotFoundException;

public class LoginController {

    private LoginRepository loginRepository;

    public LoginController() throws FileNotFoundException {
        this.loginRepository = new LoginRepository();
    }

    public Role validateLogin(String usernameInput, String passwordInput) {

        for (Login loginAtual : loginRepository.getLogins()) {

            if (loginAtual.getUsername().equals(usernameInput)
                    && loginAtual.getPassword().equals(passwordInput)) {

                return loginAtual.getRole();
            }
        }

        return Role.INVALID;
    }
}
