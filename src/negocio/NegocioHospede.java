package negocio;

import java.util.ArrayList;
import negocio.entidade.Hospede;
import negocio.execao.hospede.HospedeJaExisteException;
import negocio.execao.hospede.HospedeNaoExisteException;
import repositorio.RepositorioHospede;

public class NegocioHospede {
    private RepositorioHospede repositorio;
    private static NegocioHospede myself;


    private NegocioHospede() {
        this.repositorio = new RepositorioHospede();
    }

    public static NegocioHospede getInstace(){
        if(myself == null){
            myself = new NegocioHospede();
        }
        return myself;
    }
    
    public void cadastrarHospede(Hospede hospede) throws HospedeJaExisteException{
        Hospede h = repositorio.buscarHospede(hospede.getCpf());
        
        if(h == null){
            repositorio.cadastrarHospede(hospede);
        }
        else{
            throw new HospedeJaExisteException();
        }
    }
    public void alterarHospede(String cpf) throws HospedeNaoExisteException{
        Hospede hospede = repositorio.buscarHospede(cpf);
        int indice = repositorio.indiceHospede(cpf);
        
        if(indice != -1){
            repositorio.alterarHospede(indice, hospede);
        }
        else{
            throw new HospedeNaoExisteException();
        }
    }
    public void removerHospede(String cpf) throws HospedeNaoExisteException{
        Hospede h = repositorio.buscarHospede(cpf);
        if(h != null){
            repositorio.removerHospede(h);
        }else{
            throw new HospedeNaoExisteException();
        }
    }

    public Hospede buscarHospede(String cpf) throws HospedeNaoExisteException{
        Hospede h = repositorio.buscarHospede(cpf);

        if(h!= null){
            return h;
        }
        else{
            throw new HospedeNaoExisteException();
        }
    }
    
    public ArrayList<Hospede> listaHospedes(){
        return repositorio.recuperarTodos();
    }
}
