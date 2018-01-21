package repositorio;

import negocio.Reserva;

import java.util.ArrayList;

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

    public String removerReserva(long id){
        Reserva r = recuperarReserva(id);

        if(r != null){
            this.listaReservas.remove(r);
            return "Reserva removida!";
        }
        return "Reserva não existe!";
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
}
