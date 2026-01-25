package Repositories;

import Models.Tipologia;
import Tools.CsvFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TipologiaRepository {

    private ArrayList<Tipologia> tipologias;

    public TipologiaRepository() throws FileNotFoundException {
        this.tipologias = carregarTipologias();

    }

    private ArrayList<Tipologia> carregarTipologias() throws FileNotFoundException {
        ArrayList<String[]> linhas = CsvFileReader.read("files/tipologia.csv", ",");
        ArrayList<Tipologia> lista = new ArrayList<>();

        // CsvFileReader já removeu o header, então iteramos desde o início
        for (String[] linha : linhas) {

            // Ignorar linhas vazias ou incompletas
            if (linha.length < 3 || linha[0].trim().isEmpty()) {
                continue;
            }

            try {
                int id = Integer.parseInt(linha[0].trim());
                String descricao = linha[1].trim();
                double preco = Double.parseDouble(linha[2].trim());

                lista.add(new Tipologia(id, descricao, preco));
            } catch (NumberFormatException e) {
                System.out.println("Erro ao ler linha: " + String.join(",", linha));
            }
        }

        return lista;
    }

    public Tipologia getById(int id) {
        for (Tipologia t : tipologias) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public ArrayList<Tipologia> getAll() {
        return tipologias;
    }
}
