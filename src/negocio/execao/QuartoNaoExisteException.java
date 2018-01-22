package negocio.execao;

public class QuartoNaoExisteException extends Exception {

    public QuartoNaoExisteException() {
        super("Esse quarto não existe!");
    }
}