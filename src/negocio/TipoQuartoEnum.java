package negocio;

public enum TipoQuartoEnum {
    QuartoSolteiro(150.0), QuartoDuploSolteiro(250.0), QuartoCasal(300.0), QuartoFamilia(400.0);

    private final double preco;

    private TipoQuartoEnum(double preco){
        this.preco = preco;

    }

    public double getPreco() {
        return preco;
    }
 }


