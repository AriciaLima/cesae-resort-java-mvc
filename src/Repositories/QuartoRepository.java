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

        for (String[] linha : linhas) {
            int numero = Integer.parseInt(linha[0].trim());       // ex: 101
            int tipologiaId = Integer.parseInt(linha[1].trim());  // ex: 3

            lista.add(new Quarto(numero, tipologiaId));
        }

        return lista;
    }

    public ArrayList<Quarto> getAll() {
        return quartos;
    }

    public Quarto getByNumero(int numero) {
        for (Quarto q : quartos) {
            if (q.getNumero() == numero) {
                return q;
            }
        }
        return null;
    }
}
