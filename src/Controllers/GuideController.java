package Controllers;

import Models.Experiencia;
import Repositories.ExperienciaRepository;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GuideController {

    private ExperienciaRepository experienciaRepository;

    public GuideController() {
        try {
            this.experienciaRepository = new ExperienciaRepository();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Experiencia> getHistorico(String idGuia) {
        return experienciaRepository.getByGuia(idGuia);
    }
}
