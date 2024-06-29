package betoneira.betoneira.service.recovery;

import betoneira.betoneira.model.recovery.NotificacaoCorreio;

public class CorreioService extends DecoratorService{
    
    private final NotificacaoCorreio nc;

    public CorreioService(NotificacaoService ns, NotificacaoCorreio nc){
        super(ns);
        this.nc = nc;
    }

    @Override
    public void enviaCodigo(String codigo){
        super.enviaCodigo(codigo);
        System.out.printf("Uau! Enviamos um sedex para %s com o código %s !!", nc.getEndereco(), codigo);
    }
}
