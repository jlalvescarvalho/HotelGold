package negocio.entidade;

public class Quarto {
    private int numero;
    private TipoQuartoEnum tipo;
    private boolean ocupado;

    public static int NumeroQuarto = 1;


    public Quarto( TipoQuartoEnum tipo) {
        this.numero = NumeroQuarto++;
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public TipoQuartoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoQuartoEnum tipo) {
        this.tipo = tipo;
    }

    public boolean getOcupado() {
        return ocupado;
    }

    /* Thaís: Onde é chamado? Para confirmar uma reserva é preciso checar a disponibilidade de quartos, né? */
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

}
