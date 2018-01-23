package negocio.execao.reserva;

public class ReservaNaoExisteException extends Exception {

    public ReservaNaoExisteException() {
        super("Essa reserva não existe!");
    }
}