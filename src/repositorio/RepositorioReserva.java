package repositorio;

import negocio.entidade.Reserva;

import java.util.ArrayList;
import negocio.entidade.TipoReservaEnum;

public class RepositorioReserva {
    private ArrayList<Reserva> listaReservas;

    public RepositorioReserva() {
        this.listaReservas = new ArrayList<>();
    }

    public void cadastrarReserva(Reserva reserva){
        this.listaReservas.add(reserva);
    }

    public Reserva recuperarReserva(long id){
        for (Reserva r: this.listaReservas){
            if (r.getId() == id){
                return r;
            }
        }
        return null;
    }

    public ArrayList<Reserva> recuperarTodas() {
        return listaReservas;
    }

    public void removerReserva(Reserva reserva){
        this.listaReservas.remove(reserva);

    }


    public void atualizarReserva(int indice, Reserva reserva){
       this.listaReservas.set(indice, reserva);
    }

    public int indiceReserva(long id){
        for(int i=0; i<listaReservas.size();i++){
            if(listaReservas.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
    
    public ArrayList<TipoReservaEnum> tiposReservas(){
        ArrayList<TipoReservaEnum> tipos = new ArrayList<>();
        tipos.add(TipoReservaEnum.CafeDaManha);
        tipos.add(TipoReservaEnum.MeiaPensao);
        tipos.add(TipoReservaEnum.PensaoCompleta);
        tipos.add(TipoReservaEnum.SemRefeicaoInclusa);
        return tipos;
        }
}
