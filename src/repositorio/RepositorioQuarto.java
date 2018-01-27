package repositorio;

import negocio.entidade.Quarto;

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

    public void atualizarQuarto(int indice, Quarto quarto){
        this.listaQuartos.set(indice, quarto);
    }

    public ArrayList<Quarto> recuperarTodos() {
        return listaQuartos;
    }
    
    public ArrayList<Quarto> quartosDesocupados(){
        ArrayList<Quarto> desocupados = new ArrayList<>();
        
        for(Quarto q : listaQuartos){
            if(q.getOcupado() == false){
                desocupados.add(q);
            }
        }
        
        return desocupados;
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
