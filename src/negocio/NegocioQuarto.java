package negocio;

import java.util.ArrayList;
import negocio.entidade.Quarto;
import negocio.execao.quarto.QuartoJaExisteException;
import negocio.execao.quarto.QuartoNaoExisteException;
import repositorio.RepositorioQuarto;

public class NegocioQuarto {

    private RepositorioQuarto repositorioQuarto;

    public NegocioQuarto() {
        this.repositorioQuarto =  new RepositorioQuarto();
    }

    public void cadastrarQuarto(Quarto quarto) throws QuartoJaExisteException{

        if(repositorioQuarto.recuperarQuarto(quarto.getNumero()) == null){
            repositorioQuarto.cadastrarQuarto(quarto);
        }else{
            throw new QuartoJaExisteException();
        }
    }

    public void alterarQuarto(Quarto q) throws QuartoNaoExisteException{
        int indice = repositorioQuarto.indiceQuarto(q.getNumero());

        if(q.getOcupado() == false){
            repositorioQuarto.atualizarQuarto(indice,q);
        }else{
            throw new QuartoNaoExisteException();
        }
    }

    public void removerQuarto(int numero) throws QuartoNaoExisteException{
        Quarto q = repositorioQuarto.recuperarQuarto(numero);

        if(q != null && q.getOcupado() == false){
            repositorioQuarto.removerQuarto(q);
        }else{
            throw new QuartoNaoExisteException();
        }
    }

    public Quarto buscarQuarto(int numero) throws QuartoNaoExisteException{
        Quarto q = repositorioQuarto.recuperarQuarto(numero);

        if(q != null ){
            return q;
        }else{
            throw new QuartoNaoExisteException();
        }
    }

    public ArrayList<Quarto> recuperarTodos() {
        return repositorioQuarto.recuperarTodos();
    }
}