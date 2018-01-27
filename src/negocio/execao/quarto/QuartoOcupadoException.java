package negocio.execao.quarto;

public class QuartoOcupadoException extends Exception{

    public QuartoOcupadoException() {
        super("Quarto ocupado!");
    }
}