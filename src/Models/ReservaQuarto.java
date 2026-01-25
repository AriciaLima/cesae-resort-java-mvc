package Models;

public class ReservaQuarto {

    private String id;        // ID da reserva
    private int numQuarto;    // Número do quarto
    private String idCliente; // ID do cliente
    private int ano;          // Ano da reserva
    private int mes;          // Mês da reserva
    private int semana;       // Semana do mês

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
