package Models;

public class ReservaQuarto {

    private String id;        // R001
    private int numQuarto;    // 101
    private String idCliente; // C001
    private int ano;
    private int mes;
    private int semana;

    public ReservaQuarto(String id, int numQuarto, String idCliente, int ano, int mes, int semana) {
        this.id = id;
        this.numQuarto = numQuarto;
        this.idCliente = idCliente;
        this.ano = ano;
        this.mes = mes;
        this.semana = semana;
    }

    public String getId() { return id; }
    public int getNumQuarto() { return numQuarto; }
    public String getIdCliente() { return idCliente; }
    public int getAno() { return ano; }
    public int getMes() { return mes; }
    public int getSemana() { return semana; }
}
