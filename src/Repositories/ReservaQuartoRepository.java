package Repositories;

import Models.ReservaQuarto;
import Tools.CsvFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ReservaQuartoRepository {

    private ArrayList<ReservaQuarto> reservas;

    public ReservaQuartoRepository() throws FileNotFoundException {
        this.reservas = carregarReservas();
    }

    private ArrayList<ReservaQuarto> carregarReservas() throws FileNotFoundException {
        ArrayList<String[]> linhas = CsvFileReader.read("files/reservas_quartos.csv", ",");
        ArrayList<ReservaQuarto> lista = new ArrayList<>();

        for (String[] linha : linhas) {
            String id = linha[0];
            int numQuarto = Integer.parseInt(linha[1]);
            String idCliente = linha[2];
            int ano = Integer.parseInt(linha[3]);
            int mes = Integer.parseInt(linha[4]);
            int semana = Integer.parseInt(linha[5]);

            lista.add(new ReservaQuarto(id, numQuarto, idCliente, ano, mes, semana));
        }

        return lista;
    }

    public ArrayList<ReservaQuarto> getAll() {
        return reservas;
    }
}
