package Models;

public class Quarto {

    private int numero;       // Número do quarto
    private int tipologiaId;  // ID da tipologia

    public Quarto(int numero, int tipologiaId) {
        this.numero = numero;
        this.tipologiaId = tipologiaId;
    }

    public int getNumero() {
        return numero;
    }

    public int getTipologiaId() {
        return tipologiaId;
    }
}
