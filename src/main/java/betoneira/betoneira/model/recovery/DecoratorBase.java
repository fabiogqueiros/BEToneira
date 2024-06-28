package betoneira.betoneira.model.recovery;

public abstract class DecoratorBase{
    
    protected Recuperacao r;

    public void enviaCodigo(String codigo){
        r.enviaCodigo(codigo);
    }
}