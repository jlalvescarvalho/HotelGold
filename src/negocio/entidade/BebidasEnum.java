package negocio.entidade;

public enum BebidasEnum {
    CocaCola(5.0), Fanta(5.0), Agua(3.0), Suco(4.0), Whisky(15.0);

    private final double preco;

    BebidasEnum(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }
}
