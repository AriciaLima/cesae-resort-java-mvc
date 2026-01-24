package Repositories;

import Models.Login;
import Enums.Role;
import Tools.CsvFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class LoginRepository {

    private ArrayList<Login> logins;

    public LoginRepository() throws FileNotFoundException {
        this.logins = carregarLogins();
    }

    public ArrayList<Login> getLogins() {
        return logins;
    }

    private ArrayList<Login> carregarLogins() throws FileNotFoundException {

        ArrayList<String[]> linhas = CsvFileReader.read("files/logins.csv", ",");

        ArrayList<Login> lista = new ArrayList<>();

        for (String[] linha : linhas) {

            String username = linha[0].trim();
            String password = linha[1].trim();
            Role role = Role.valueOf(linha[2].trim().toUpperCase());

            lista.add(new Login(username, password, role));
        }

        return lista;
    }
}
