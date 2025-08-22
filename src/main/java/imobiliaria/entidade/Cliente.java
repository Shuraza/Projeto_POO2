package imobiliaria.entidade;

public class Cliente {

    private long id;
    private String nome;
    private String email;
    private int idade;
    private String sexo;

    public Cliente(long id, String nome, String email, int idade, String sexo){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.sexo = sexo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
