package Repositories;

import Models.ReservaQuarto;
import Tools.CsvFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ReservaRepository {

    private ArrayList<ReservaQuarto> reservas;

    public ReservaRepository() throws FileNotFoundException {
        this.reservas = carregarReservas();
    }

    private ArrayList<ReservaQuarto> carregarReservas() throws FileNotFoundException {
        ArrayList<String[]> linhas = CsvFileReader.read("files/reservas_quartos.csv", ",");
        ArrayList<ReservaQuarto> lista = new ArrayList<>();

        // CsvFileReader já removeu o header, então iteramos desde o início
        for (String[] linha : linhas) {

            // Ignorar linhas vazias ou incompletas
            if (linha.length < 6) {
                continue;
            }

            String id = linha[0].trim();
            int numQuarto = Integer.parseInt(linha[1].trim());
            String idCliente = linha[2].trim();
            int ano = Integer.parseInt(linha[3].trim());
            int mes = Integer.parseInt(linha[4].trim());
            int semana = Integer.parseInt(linha[5].trim());

            lista.add(new ReservaQuarto(id, numQuarto, idCliente, ano, mes, semana));
        }

        return lista;
    }

    public ArrayList<ReservaQuarto> getAll() {
        return reservas;
    }
}
