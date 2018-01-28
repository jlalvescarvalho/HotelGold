package repositorio;

import negocio.entidade.Quarto;

import java.util.ArrayList;
import negocio.entidade.TipoQuartoEnum;

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
    
    public ArrayList<TipoQuartoEnum> tiposQuartosDesocupados(){
        ArrayList<Quarto> quartosVagos = quartosDesocupados();
        ArrayList<TipoQuartoEnum> tipos = new ArrayList<>();
        
        for(Quarto q : quartosVagos){
            if(q.getTipo().name().equals(TipoQuartoEnum.QuartoCasal.name()) && !tipos.contains(TipoQuartoEnum.QuartoCasal)){
                tipos.add(TipoQuartoEnum.QuartoCasal);
            }else if(q.getTipo().name().equals(TipoQuartoEnum.QuartoSolteiro.name()) && !tipos.contains(TipoQuartoEnum.QuartoSolteiro)){
                tipos.add(TipoQuartoEnum.QuartoSolteiro);
            }else if(q.getTipo().name().equals(TipoQuartoEnum.QuartoDuploSolteiro.name()) && !tipos.contains(TipoQuartoEnum.QuartoDuploSolteiro)){
                tipos.add(TipoQuartoEnum.QuartoDuploSolteiro);
            }else if(q.getTipo().name().equals(TipoQuartoEnum.QuartoFamilia.name()) && !tipos.contains(TipoQuartoEnum.QuartoFamilia)){
                tipos.add(TipoQuartoEnum.QuartoFamilia);
            }
        }
        return tipos;
    }

}
