package Models;

public class Quarto {
    private String numero;
    private int tipologiaId;

    public Quarto(String numero, int tipologiaId) {
        this.numero = numero;
        this.tipologiaId = tipologiaId;
    }

    public String getNumero() {
        return numero;
    }

    public int getTipologiaId() {
        return tipologiaId;
    }
}
