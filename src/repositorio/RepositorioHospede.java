package repositorio;

import negocio.Hospede;

import java.util.ArrayList;

public class RepositorioHospede {
    private ArrayList<Hospede> listaHospedes;

    public RepositorioHospede() {
        this.listaHospedes = new ArrayList<>();
    }



    public String cadastrarHospede(Hospede hospede) {
        this.listaHospedes.add(hospede);
        return "Hospede cadastrado!";
    }

    public Hospede recuperarHospede(String cpf){
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

    public void alterarHospede(Hospede hospede, int indice){
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
