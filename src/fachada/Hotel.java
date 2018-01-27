package fachada;

import negocio.NegocioHospede;
import negocio.NegocioQuarto;
import negocio.NegocioReserva;
import negocio.entidade.Hospede;
import negocio.entidade.Quarto;
import negocio.entidade.Reserva;
import negocio.execao.hospede.HospedeJaExisteException;
import negocio.execao.hospede.HospedeNaoExisteException;
import negocio.execao.quarto.QuartoJaExisteException;
import negocio.execao.quarto.QuartoNaoExisteException;
import negocio.execao.quarto.QuartoOcupadoException;
import negocio.execao.reserva.ReservaNaoExisteException;

public class Hotel {

    private NegocioQuarto negocioQuarto;
    private NegocioHospede negocioHospede;
    private NegocioReserva negocioReserva;
    private static Hotel myself;

    private Hotel() {
        this.negocioQuarto = new NegocioQuarto();
        this.negocioHospede = new NegocioHospede();
        this.negocioReserva = new NegocioReserva();
    }
    
    public static Hotel getInstance(){
        if(myself == null){
            myself = new Hotel();
        }
        return myself;
    }

    public void adicionarQuarto(Quarto quarto) throws QuartoJaExisteException {
        negocioQuarto.cadastrarQuarto(quarto);
    }

    public void adicionarHospede(Hospede hospede) throws HospedeJaExisteException{
        negocioHospede.cadastrarHospede(hospede);
    }

    public void adicionarReserva(Reserva reserva) throws HospedeNaoExisteException, QuartoNaoExisteException, QuartoOcupadoException{
        negocioReserva.cadastarReserva(reserva);
    }

    public void buscarQuarto(int numero) throws QuartoNaoExisteException {
        negocioQuarto.buscarQuarto(numero);
    }

    public void buscarHospede(String cpf) throws HospedeNaoExisteException{
        negocioHospede.buscarHospede(cpf);
    }

    public void buscarReserva(long id) throws ReservaNaoExisteException {
        negocioReserva.buscarReserva(id);
    }

    public void alterarQuarto(int numero) throws QuartoNaoExisteException {
        negocioQuarto.alterarQuarto(numero);
    }

    public void alterarHospede(String cpf) throws HospedeNaoExisteException{
        negocioHospede.alterarHospede(cpf);
    }

    public void alterarReserva(Reserva reserva) throws ReservaNaoExisteException {
        negocioReserva.alterarReserva(reserva);
    }

    public void removerQuarto(int numero) throws QuartoNaoExisteException {
        negocioQuarto.removerQuarto(numero);
    }

    public void removerHospede(String cpf) throws HospedeNaoExisteException{
        negocioHospede.removerHospede(cpf);
    }

    public void removerReserva(long id) throws ReservaNaoExisteException {
        negocioReserva.removerReserva(id);
    }
}