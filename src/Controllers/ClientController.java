package Controllers;

import Models.Quarto;
import Models.Tipologia;
import Repositories.QuartoRepository;
import Repositories.TipologiaRepository;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ClientController {

    private QuartoRepository quartoRepository;
    private TipologiaRepository tipologiaRepository;

    public ClientController() throws FileNotFoundException {
        this.quartoRepository = new QuartoRepository();
        this.tipologiaRepository = new TipologiaRepository();
    }

    public ArrayList<String[]> consultarQuartosDisponiveis() {

        ArrayList<String[]> tabela = new ArrayList<>();

        for (Quarto q : quartoRepository.getAll()) {

            Tipologia t = tipologiaRepository.getById(q.getTipologiaId());

            tabela.add(new String[]{
                    String.valueOf(q.getNumero()),
                    t.getDescricao(),
                    String.valueOf(t.getPrecoPorSemana())
            });
        }

        return tabela;
    }
}
