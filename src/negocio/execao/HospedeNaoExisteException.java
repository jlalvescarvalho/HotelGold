package negocio.execao;

public class HospedeNaoExisteException extends Exception {

    public HospedeNaoExisteException() {
        super("Esse hóspede não existe!");
    }
}
