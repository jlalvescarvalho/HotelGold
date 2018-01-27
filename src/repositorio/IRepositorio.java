package repositorio;

public interface IRepositorio {
    
    public void cadastrar(Object obj);
    
    public void remover(Object obj);
    
    public Object alterar(int ind, Object obj);
}
