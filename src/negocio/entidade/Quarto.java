package negocio.entidade;

public class Quarto {
    private int numero;
    private TipoQuartoEnum tipo;
    private boolean ocupado;

    private static int NumeroQuarto = 1;


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

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Quarto) {
            Quarto quarto = (Quarto) obj;
            if (this.numero == quarto.getNumero() && this.tipo.equals(quarto.getTipo())) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Número do Quarto: " + this.numero + "; Tipo do Quarto: " + this.tipo.name();
    }
}
