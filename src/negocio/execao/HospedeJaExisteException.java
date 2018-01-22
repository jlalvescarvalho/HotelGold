package negocio.execao;

public class HospedeJaExisteException extends Exception {

    public HospedeJaExisteException() {
        super("Esse hospede já existe, não é possível adicioná-lo novamente.");
    }
}