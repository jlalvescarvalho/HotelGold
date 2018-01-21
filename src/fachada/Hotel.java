package fachada;

import negocio.*;

public class Hotel {

    private NegocioQuarto negocioQuarto;
    private NegocioHospede negocioHospede;
    private NegocioReserva negocioReserva;

    public Hotel() {
        this.negocioQuarto = new NegocioQuarto();
        this.negocioHospede = new NegocioHospede();
        this.negocioReserva = new NegocioReserva();
    }

    public void adicionarQuarto(Quarto quarto) {
        negocioQuarto.cadastrarQuarto(quarto);
    }

    public void adicionarHospede(Hospede hospede) {
        negocioHospede.cadastrarHospede(hospede);
    }

    public void adicionarReserva(Reserva reserva) {
        negocioReserva.cadastarReserva(reserva);
    }

    public void buscarQuarto(int numero) {
        negocioQuarto.buscarQuarto(numero);
    }

    public void buscarHospede(String cpf) {
        negocioHospede.buscarHospede(cpf);
    }

    public void buscarReserva(long id) {
        negocioReserva.buscarReserva(id);
    }

    public void alterarQuarto(int numero) {
        negocioQuarto.alterarQuarto(numero);
    }

    public void alterarHospede(String cpf) {
        negocioHospede.alterarHospede(cpf);
    }

    public void alterarReserva(Reserva reserva) {
        negocioReserva.alterarReserva(reserva);
    }

    public void removerQuarto(int numero) {
        negocioQuarto.removerQuarto(numero);
    }

    public void removerHospede(String cpf) {
        negocioHospede.removerHospede(cpf);
    }



}
