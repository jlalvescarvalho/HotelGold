package negocio.execao.hospede;

public class HospedeJaExisteException extends Exception {

    public HospedeJaExisteException() {
        super("Esse hospede já existe, não é possível adicioná-lo novamente.");
    }
}