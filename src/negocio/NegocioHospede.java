package negocio;

import repositorio.RepositorioHospede;

public class NegocioHospede {
    private RepositorioHospede repositorio;


    public NegocioHospede() {
        this.repositorio = new RepositorioHospede();
    }


    public String cadastrarHospede(Hospede hospede){
        if(repositorio.buscarHospede(hospede.getCpf())== null){
            repositorio.cadastrarHospede(hospede);
            return "Cadastrado com sucesso";
        }
        else{
            return "Este hóspede já está cadastrado.";
        }
    }
    public void alterarHospede(String cpf){
        Hospede hospede = repositorio.buscarHospede(cpf);
        int indice = repositorio.indiceHospede(cpf);
        if(indice != -1){
            repositorio.alterarHospede(hospede, indice);
        }
        else{

        }
    }
    public void removerHospede(String cpf){
        Hospede h = repositorio.buscarHospede(cpf);
        if(h != null){
            repositorio.removerHospede(h);
        }else{

        }
    }

    public Hospede buscarHospede(String cpf){
        Hospede h = repositorio.buscarHospede(cpf);

        if(h!= null){
            return h;
        }
        else{
            return null;
        }
    }
}
