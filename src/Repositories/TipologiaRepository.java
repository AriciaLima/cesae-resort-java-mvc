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

        for (int i = 0; i < linhas.size(); i++) { // NÃO ignorar a primeira linha
            String[] linha = linhas.get(i);

            int id = Integer.parseInt(linha[0].trim());
            String descricao = linha[1].trim();
            double preco = Double.parseDouble(linha[2].trim());

            lista.add(new Tipologia(id, descricao, preco));
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
