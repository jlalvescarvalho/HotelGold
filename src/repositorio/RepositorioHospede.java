package repositorio;

import negocio.entidade.Hospede;

import java.util.ArrayList;

public class RepositorioHospede {
    private ArrayList<Hospede> listaHospedes;

    public RepositorioHospede() {
        this.listaHospedes = new ArrayList<>();
    }



    public void cadastrarHospede(Hospede hospede) {
        this.listaHospedes.add(hospede);
    }

    public Hospede buscarHospede(String cpf){
        for(int i = 0; i < this.listaHospedes.size(); i++){
            if (this.listaHospedes.get(i).getCpf().equals(cpf)){
                return this.listaHospedes.get(i);
            }
        }
        return null;
    }

    public void removerHospede(Hospede hospede){
        listaHospedes.remove(hospede);
    }

    public void alterarHospede( int indice, Hospede hospede){
        listaHospedes.set(indice, hospede);
    }

    public ArrayList<Hospede> recuperarTodos() {
        return listaHospedes;
    }

    public int indiceHospede(String cpf){
        for(int i=0; i<listaHospedes.size();i++){
            if(listaHospedes.get(i).getCpf().equals(cpf)){
                return i;
            }
        }
        return -1;
    }



}
