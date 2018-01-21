package negocio;

import repositorio.RepositorioQuarto;

public class NegocioQuarto {

    private RepositorioQuarto repositorioQuarto;

    public NegocioQuarto() {
        this.repositorioQuarto =  new RepositorioQuarto();
    }

    public void cadastrarQuarto(Quarto quarto){

        if(repositorioQuarto.recuperarQuarto(quarto.getNumero()) == null){
            repositorioQuarto.cadastrarQuarto(quarto);
        }else{

        }
    }

    public void alterarQuarto(int numero){
        Quarto q = repositorioQuarto.recuperarQuarto(numero);
        int indice = repositorioQuarto.indiceQuarto(numero);

        if(q != null && q.getOcupado() == false){
            repositorioQuarto.atualizarQuarto(indice,q);
        }else{

        }

    }

    public void removerQuarto(int numero){
        Quarto q = repositorioQuarto.recuperarQuarto(numero);

        if(q != null && q.getOcupado() == false){
            repositorioQuarto.removerQuarto(q);
        }else{

        }
    }

    public Quarto buscarQuarto(int numero){
        Quarto q = repositorioQuarto.recuperarQuarto(numero);

        if(q != null ){
            return q;
        }else{
            return null;
        }
    }

}
