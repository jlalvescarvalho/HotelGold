package negocio.entidade;

public class Hospede {
    private String nome;
    private String cpf;
    private String telefone;
    private Endereco endereco;
    private int frequencia;


    public Hospede(String nome, String cpf, String telefone, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.frequencia = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getFrequencia() {
        return frequencia;
    }
    
    public void zerarFrequencia() {
        this.frequencia = 0;
    }
    public void incrementarFrequencia(){
        this.frequencia++;
    }
}
