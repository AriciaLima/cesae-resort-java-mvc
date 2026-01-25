package Repositories;

import Models.Experiencia;
import Tools.CsvFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ExperienciaRepository {

    private ArrayList<Experiencia> experiencias;

    public ExperienciaRepository() throws FileNotFoundException {
        this.experiencias = carregarExperiencias();
    }

    private ArrayList<Experiencia> carregarExperiencias() throws FileNotFoundException {

        ArrayList<String[]> linhas = CsvFileReader.read("files/experiencias.csv", ",");
        ArrayList<Experiencia> lista = new ArrayList<>();

        for (String[] linha : linhas) {

            String id = linha[0].trim();
            String nome = linha[1].trim();
            String idGuia = linha[2].trim();
            int precoAdulto = Integer.parseInt(linha[3].trim());
            int precoCrianca = Integer.parseInt(linha[4].trim());

            lista.add(new Experiencia(id, nome, idGuia, precoAdulto, precoCrianca));
        }

        return lista;
    }

    public ArrayList<Experiencia> getByGuia(String idGuia) {
        ArrayList<Experiencia> lista = new ArrayList<>();

        for (Experiencia e : experiencias) {
            if (e.getIdGuia().equals(idGuia)) {
                lista.add(e);
            }
        }

        return lista;
    }

    public ArrayList<Experiencia> getAll() {
        return experiencias;
    }
}
