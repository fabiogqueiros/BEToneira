package betoneira.betoneira.service.recovery;

public abstract class DecoratorService extends NotificacaoService{
    
    protected final NotificacaoService ns;

    protected DecoratorService(NotificacaoService ns){
        this.ns = ns;
    }

    @Override
    public void enviaCodigo(String codigo){
        ns.enviaCodigo(codigo);
    }
}