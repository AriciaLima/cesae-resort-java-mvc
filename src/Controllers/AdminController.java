package Controllers;

import Models.Tipologia;
import Models.Quarto;
import Models.ReservaQuarto;
import Repositories.ReservaRepository;
import Repositories.QuartoRepository;
import Repositories.TipologiaRepository;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class AdminController {

    private ReservaRepository reservaRepository;
    private QuartoRepository quartoRepository;
    private TipologiaRepository tipologiaRepository;

    public AdminController() throws FileNotFoundException {
        this.reservaRepository = new ReservaRepository();
        this.quartoRepository = new QuartoRepository();
        this.tipologiaRepository = new TipologiaRepository();
    }

    /**
     * Devolve uma lista de arrays de Strings com as tipologias mais reservadas (pode haver empate).
     * Cada array contém:
     * [0] = ID da tipologia
     * [1] = Descrição
     * [2] = Preço por semana
     * [3] = Número de reservas
     */
    public ArrayList<String[]> tipologiaMaisReservada() {

        ArrayList<ReservaQuarto> reservas = reservaRepository.getAll();
        ArrayList<Quarto> quartos = quartoRepository.getAll();

        HashMap<Integer, Integer> mapaQuartoTipologia = new HashMap<>();
        for (Quarto q : quartos) {
            mapaQuartoTipologia.put(q.getNumero(), q.getTipologiaId());
        }

        HashMap<Integer, Integer> contador = new HashMap<>();
        for (ReservaQuarto r : reservas) {
            int numQuarto = r.getNumQuarto();
            Integer tipologiaId = mapaQuartoTipologia.get(numQuarto);

            if (tipologiaId != null) {
                contador.put(tipologiaId, contador.getOrDefault(tipologiaId, 0) + 1);
            }
        }

        int max = 0;
        // Encontrar o valor máximo
        for (int total : contador.values()) {
            if (total > max) {
                max = total;
            }
        }

        ArrayList<String[]> resultados = new ArrayList<>();

        if (max == 0) {
            resultados.add(new String[]{
                    "-",
                    "Sem reservas",
                    "-",
                    "0"
            });
            return resultados;
        }

        // Coletar todas as tipologias que têm o valor máximo
        for (int id : contador.keySet()) {
            if (contador.get(id) == max) {
                Tipologia t = tipologiaRepository.getById(id);
                if (t != null) {
                    resultados.add(new String[]{
                            String.valueOf(t.getId()),
                            t.getDescricao(),
                            String.valueOf(t.getPrecoPorSemana()),
                            String.valueOf(max)
                    });
                }
            }
        }

        return resultados;
    }
}
