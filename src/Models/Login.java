package Models;

import Enums.Role;

/**
 * Representa um utilizador do sistema.
 */
public class Login {

    private Role role;
    private String username;
    private String password;

    public Login(String username, String password, Role role) {
        this.role = role;
        this.username = username;
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {

        return password;
    }
}
