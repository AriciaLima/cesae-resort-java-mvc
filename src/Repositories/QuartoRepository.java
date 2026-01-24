package Repositories;

import Models.Quarto;
import Tools.CsvFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class QuartoRepository {

    private ArrayList<Quarto> quartos;

    public QuartoRepository() throws FileNotFoundException {
        this.quartos = carregarQuartos();
    }

    private ArrayList<Quarto> carregarQuartos() throws FileNotFoundException {
        ArrayList<String[]> linhas = CsvFileReader.read("files/quartos.csv", ",");
        ArrayList<Quarto> lista = new ArrayList<>();

        for (int i = 1; i < linhas.size(); i++) {
            String[] linha = linhas.get(i);

            String numero = linha[0].trim(); // ex: "101"
            int tipologiaId = Integer.parseInt(linha[1].trim()); // ex: 3

            lista.add(new Quarto(numero, tipologiaId));
        }

        return lista;
    }

    public ArrayList<Quarto> getAll() {
        return quartos;
    }
}
