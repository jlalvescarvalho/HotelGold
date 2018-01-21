package negocio;

public enum RefeicaoEnum {
    CafeDaManha(20.0), Almoco(30.0), Janta(20.0);

    private final double preco;

    RefeicaoEnum(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }
}
