package negocio.execao.quarto;

public class QuartoNaoExisteException extends Exception {

    public QuartoNaoExisteException() {
        super("Esse quarto não existe!");
    }
}