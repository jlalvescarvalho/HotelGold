package repositorio;

import negocio.Quarto;

import java.util.ArrayList;

public class RepositorioQuarto {
    private ArrayList<Quarto> listaQuartos;

    public RepositorioQuarto() {
        this.listaQuartos = new ArrayList<>();
    }

    public void cadastrarQuarto(Quarto quarto){
        this.listaQuartos.add(quarto);
    }

    public Quarto recuperarQuarto(int numero){
        for (Quarto q : listaQuartos){
            if (q.getNumero() == numero){
                return q;
            }
        }
        return null;
    }

    public void removerQuarto(Quarto quarto){
        this.listaQuartos.remove(quarto);
    }

    /* Thaís: Tem que checar a disponibilidade também. Além disso, por que remover e recadastrar a reserva, ao invés
    *  de simplesmente alterá-la?! */
    public void atualizarQuarto(int indice, Quarto quarto){
        this.listaQuartos.set(indice, quarto);
    }

    public ArrayList<Quarto> recuperarTodos() {
        return listaQuartos;
    }

    public int indiceQuarto(int numero){
        for(int i=0; i<listaQuartos.size();i++){
            if(listaQuartos.get(i).getNumero() == numero){
                return i;
            }
        }
        return -1;
    }

}
