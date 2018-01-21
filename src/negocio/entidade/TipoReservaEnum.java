package negocio.entidade;

public enum TipoReservaEnum {
    SemRefeicaoInclusa(0.0), CafeDaManha(20.0), MeiaPensao(60.0), PensaoCompleta(80.0);

    private final double preco;

    TipoReservaEnum(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }
}
