package fachada;

import java.util.ArrayList;
import negocio.NegocioHospede;
import negocio.NegocioQuarto;
import negocio.NegocioReserva;
import negocio.entidade.Hospede;
import negocio.entidade.Quarto;
import negocio.entidade.Reserva;
import negocio.entidade.TipoQuartoEnum;
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

    public Quarto buscarQuarto(int numero) throws QuartoNaoExisteException {
        return negocioQuarto.buscarQuarto(numero);
    }

    public Hospede buscarHospede(String cpf) throws HospedeNaoExisteException{
        return negocioHospede.buscarHospede(cpf);
    }

    public Reserva buscarReserva(long id) throws ReservaNaoExisteException {
        return negocioReserva.buscarReserva(id);
    }

    public void alterarQuarto(int numero) throws QuartoNaoExisteException {
        negocioQuarto.alterarQuarto(numero);
    }

    public void alterarHospede(Hospede hospede) throws HospedeNaoExisteException{
        negocioHospede.alterarHospede(hospede.getCpf());
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
    
    public ArrayList<Hospede> listaHospedes(){
        return negocioHospede.listaHospedes();
    }
    public ArrayList<Quarto> listaQuartos(){
        return negocioQuarto.recuperarTodos();
    }
    
    public ArrayList<TipoQuartoEnum> tiposQuartosVagos(){
        return negocioQuarto.tiposQuartosVagos();
    }
}