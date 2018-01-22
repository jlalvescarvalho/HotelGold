package negocio.execao;

public class ReservaJaExisteException extends Exception {

    public ReservaJaExisteException() {
        super("Essa reserva já existe, não é possivel adicioná-la novamente.");
    }
}