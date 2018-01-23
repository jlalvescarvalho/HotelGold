package negocio.execao.quarto;

public class QuartoJaExisteException extends Exception {

    public QuartoJaExisteException() {
        super("Esse quarto já existe, não é possível adicioná-lo novamente.");
    }
}