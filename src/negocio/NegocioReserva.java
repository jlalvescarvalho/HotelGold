package negocio;

import java.util.ArrayList;
import negocio.entidade.Hospede;
import negocio.entidade.Quarto;
import negocio.entidade.Reserva;
import negocio.entidade.TipoQuartoEnum;
import negocio.entidade.TipoReservaEnum;
import negocio.execao.hospede.HospedeNaoExisteException;
import negocio.execao.quarto.QuartoNaoExisteException;
import negocio.execao.quarto.QuartoOcupadoException;
import negocio.execao.reserva.ReservaJaExisteException;
import negocio.execao.reserva.ReservaNaoExisteException;
import repositorio.RepositorioReserva;

public class NegocioReserva {

    private RepositorioReserva repositorioReserva;
    private NegocioHospede negocioHospede;
    private NegocioQuarto negocioQuarto;

    public NegocioReserva() {
        this.repositorioReserva = new RepositorioReserva();
        this.negocioHospede = new NegocioHospede();
        this.negocioQuarto = new NegocioQuarto();
    }

    public void cadastarReserva(Reserva reserva) throws HospedeNaoExisteException, QuartoNaoExisteException, QuartoOcupadoException, ReservaJaExisteException {
        Quarto quarto = negocioQuarto.buscarQuarto(reserva.getQuarto().getNumero());
        Hospede hospede = negocioHospede.buscarHospede(reserva.getHospede().getCpf());
        Reserva r = repositorioReserva.recuperarReserva(reserva.getId());
        if (r != null) {
            throw new ReservaJaExisteException();
        }
        if (quarto == null) {
            throw new QuartoNaoExisteException();
        } else if (hospede == null) {
            throw new HospedeNaoExisteException();
        } else if (reserva.getQuarto().getOcupado() != false) {
            throw new QuartoOcupadoException();
        } else {
            reserva.getQuarto().setOcupado(true);
            repositorioReserva.cadastrarReserva(reserva);
        }
    }

    public Reserva buscarReserva(long id) throws ReservaNaoExisteException {
        Reserva reserva = repositorioReserva.recuperarReserva(id);

        if (reserva != null) {
            return reserva;
        } else {
            throw new ReservaNaoExisteException();
        }

    }

    public void alterarReserva(Reserva reserva) throws ReservaNaoExisteException {
        Reserva r = repositorioReserva.recuperarReserva(reserva.getId());
        int indice = repositorioReserva.indiceReserva(reserva.getId());

        if (r != null) {
            repositorioReserva.atualizarReserva(indice, reserva);
        } else {
            throw new ReservaNaoExisteException();
        }

    }

    public void removerReserva(long id) throws ReservaNaoExisteException {
        Reserva r = buscarReserva(id);

        if (r != null) {
            repositorioReserva.removerReserva(r);
        } else {
            throw new ReservaNaoExisteException();
        }
    }

    public ArrayList<TipoReservaEnum> tiposReservas() {
        return repositorioReserva.tiposReservas();

    }

}
