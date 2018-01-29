package negocio.entidade;

import java.util.ArrayList;

public class CartaoConsumo {

    private ArrayList<Enum> listaConsumo;

    public CartaoConsumo() {
        this.listaConsumo =  new ArrayList();
    }
    public void consumir(Enum consumo){
       listaConsumo.add(consumo);
    }
    public double calcularConsumo(){
        double total = 0;
        for(Enum c: listaConsumo){
            if (c instanceof BebidasEnum){
                total += ((BebidasEnum)c).getPreco();
            }
            else{
                total += ((RefeicoesEnum)c).getPreco();
            }
        }

        return total;
    }

    public ArrayList<Enum> getListaConsumo() {
        return listaConsumo;
    }

    public void removerItem(Enum item){
        if (listaConsumo.contains(item)) {
            listaConsumo.remove(item);
        }
        else{

        }
    }
}
