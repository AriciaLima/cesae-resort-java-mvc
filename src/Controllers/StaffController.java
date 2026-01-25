package Controllers;

import Models.Quarto;
import Models.ReservaQuarto;
import Models.Tipologia;
import Repositories.QuartoRepository;
import Repositories.ReservaRepository;
import Repositories.TipologiaRepository;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

public class StaffController {

    private final ReservaRepository reservaRepository;
    private final QuartoRepository quartoRepository;
    private final TipologiaRepository tipologiaRepository;

    public StaffController() throws FileNotFoundException {
        this.reservaRepository = new ReservaRepository();
        this.quartoRepository = new QuartoRepository();
        this.tipologiaRepository = new TipologiaRepository();
    }

    public ArrayList<String[]> quartosDisponiveisSemanaAtual() {

        LocalDate hoje = LocalDate.now();
        int anoAtual = hoje.getYear();
        int mesAtual = hoje.getMonthValue();
        int semanaAtual = hoje.get(WeekFields.of(Locale.getDefault()).weekOfMonth());

        ArrayList<ReservaQuarto> reservas = reservaRepository.getAll();
        ArrayList<Quarto> quartos = quartoRepository.getAll();

        HashSet<Integer> quartosReservados = new HashSet<>();
        for (ReservaQuarto r : reservas) {
            if (r.getAno() == anoAtual && r.getMes() == mesAtual && r.getSemana() == semanaAtual) {
                quartosReservados.add(r.getNumQuarto());
            }
        }

        ArrayList<String[]> disponiveis = new ArrayList<>();
        for (Quarto q : quartos) {
            if (!quartosReservados.contains(q.getNumero())) {
                Tipologia t = tipologiaRepository.getById(q.getTipologiaId());
                if (t != null) {
                    disponiveis.add(new String[]{
                            String.valueOf(q.getNumero()),
                            t.getDescricao(),
                            String.valueOf(t.getPrecoPorSemana())
                    });
                }
            }
        }

        return disponiveis;
    }
}
