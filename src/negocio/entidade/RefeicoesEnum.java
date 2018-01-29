package negocio.entidade;

public enum RefeicoesEnum {
    CafeDaManha(20.0), Almoco(30.0), Janta(20.0);

    private final double preco;

    RefeicoesEnum(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }
}
