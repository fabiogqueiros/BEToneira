package betoneira.betoneira.model.recovery;

public abstract class DecoratorBase extends Notificacao{
    
    protected Notificacao n;

    protected DecoratorBase(Notificacao n){
        this.n = n;
    }

    public void enviaCodigo(String codigo){
        n.enviaCodigo(codigo);
    }
}