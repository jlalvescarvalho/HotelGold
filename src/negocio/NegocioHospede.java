package negocio;

import negocio.entidade.Hospede;
import repositorio.RepositorioHospede;

public class NegocioHospede {
    private RepositorioHospede repositorio;


    public NegocioHospede() {
        this.repositorio = new RepositorioHospede();
    }


    public String cadastrarHospede(Hospede hospede){
        if(repositorio.recuperarHospede(hospede.getCpf())== null){
            repositorio.cadastrarHospede(hospede);
            return "Cadastrado com sucesso";
        }
        else{
            return "Este hóspede já está cadastrado.";
        }
    }
    public void alterarHospede(Hospede hospede){
        int indice = repositorio.indiceHospede(hospede.getCpf());
        if(indice != -1){
            repositorio.alterarHospede(hospede, indice);
        }
        else{

        }
    }
    public void removerHospede(String cpf){
        Hospede h = repositorio.recuperarHospede(cpf);
        if(h != null){
            repositorio.removerHospede(h);
        }else{

        }
    }

    public Hospede recuperarHospede(String cpf){
        Hospede h = repositorio.recuperarHospede(cpf);

        if(h!= null){
            return h;
        }
        else{
            return null;
        }
    }
}
