package negocio.entidade;

public class Hospede {
    private String nome;
    private String cpf;
    private CartaoConsumo cartaoConsumo;
    private String telefone;
    private int frequencia;


    public Hospede(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.cartaoConsumo = new CartaoConsumo();
        this.telefone = telefone;
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

    public CartaoConsumo getCartaoConsumo() {
        return cartaoConsumo;
    }

    public void setCartaoConsumo(CartaoConsumo cartaoConsumo) {
        this.cartaoConsumo = cartaoConsumo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Hospede) {
            Hospede hospede = (Hospede) obj;
            if (this.cpf.equals(hospede.getCpf())) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Nome do Hospede: " + this.nome + "; cpf: " + this.cpf ;
    }
}
