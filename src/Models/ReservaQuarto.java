package Models;

public class ReservaQuarto {
    private String id;
    private String numQuarto;
    private String idCliente;
    private int ano;
    private int mes;
    private int semana;

    public ReservaQuarto(String id, String numQuarto, String idCliente, int ano, int mes, int semana) {
        this.id = id;
        this.numQuarto = numQuarto;
        this.idCliente = idCliente;
        this.ano = ano;
        this.mes = mes;
        this.semana = semana;
    }

    public String getNumQuarto() {
        return numQuarto;
    }
}
