package Models;

public class Tipologia {

    private int id;
    private String descricao;
    private double precoPorSemana;

    public Tipologia(int id, String descricao, double precoPorSemana) {
        this.id = id;
        this.descricao = descricao;
        this.precoPorSemana = precoPorSemana;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPrecoPorSemana() {
        return precoPorSemana;
    }
}
