package Models;

public class Tipologia {

    private int id;                 // ID da tipologia
    private String descricao;       // Nome/descrição
    private double precoPorSemana;  // Preço por semana

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
