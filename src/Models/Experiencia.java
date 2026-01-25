package Models;

public class Experiencia {

    private String id;
    private String nome;
    private String idGuia;
    private int precoAdulto;
    private int precoCrianca;

    public Experiencia(String id, String nome, String idGuia, int precoAdulto, int precoCrianca) {
        this.id = id;
        this.nome = nome;
        this.idGuia = idGuia;
        this.precoAdulto = precoAdulto;
        this.precoCrianca = precoCrianca;
    }

    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getIdGuia() { return idGuia; }
    public int getPrecoAdulto() { return precoAdulto; }
    public int getPrecoCrianca() { return precoCrianca; }
}
