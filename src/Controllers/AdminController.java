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

    public Tipologia tipologiaMaisReservada() {
        ArrayList<ReservaQuarto> reservas = reservaRepository.getAll();
        ArrayList<Quarto> quartos = quartoRepository.getAll();

        HashMap<String, Integer> mapaQuartoTipologia = new HashMap<>();
        for (Quarto q : quartos) {
            mapaQuartoTipologia.put(q.getNumero(), q.getTipologiaId());
        }

        HashMap<Integer, Integer> contador = new HashMap<>();
        for (ReservaQuarto r : reservas) {
            String numQuarto = r.getNumQuarto();
            Integer tipologiaId = mapaQuartoTipologia.get(numQuarto);

            if (tipologiaId != null) {
                contador.put(tipologiaId, contador.getOrDefault(tipologiaId, 0) + 1);
            }
        }

        int idMaisReservada = -1;
        int max = 0;
        for (int id : contador.keySet()) {
            if (contador.get(id) > max) {
                max = contador.get(id);
                idMaisReservada = id;
            }
        }

        return tipologiaRepository.getById(idMaisReservada);
    }
}
