package negocio;

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

    public void cadastarReserva(Reserva reserva){
        Quarto  quarto = negocioQuarto.buscarQuarto(reserva.getQuarto().getNumero());
        Hospede hospede = negocioHospede.buscarHospede(reserva.getHospede().getCpf());

        if(quarto != null && hospede != null && reserva.getQuarto().getOcupado() == false){
            reserva.getQuarto().setOcupado(true);
            repositorioReserva.cadastrarReserva(reserva);
        }else{

        }
    }

    public Reserva buscarReserva(long id){
        Reserva reserva = repositorioReserva.recuperarReserva(id);

        if(reserva != null){
            return reserva;
        }else{
            return null;
        }

    }

    public void alterarReserva(Reserva reserva){
        Reserva r = repositorioReserva.recuperarReserva(reserva.getId());
        int indice = repositorioReserva.indiceReserva(reserva.getId());

        if(r != null){
            repositorioReserva.atualizarReserva(indice,reserva);
        }else{

        }

    }

    public void removerReserva(long id){
        Reserva r = buscarReserva(id);

        if(r != null){
            repositorioReserva.removerReserva(r);
        }
        else{

        }

    }

}
