package imobiliaria.entidade;

public class Imovel {

    private long id;
    private String tipo;
    private float tamanho;
    private String endereco;

    public Imovel(long id, String tipo, float tamanho, String endereco){
        this.id = id;
        this.tipo = tipo;
        this.tamanho = tamanho;
        this.endereco = endereco;
    }

    public long getId() {
        return id;
    }

    public float getTamanho() {
        return tamanho;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
