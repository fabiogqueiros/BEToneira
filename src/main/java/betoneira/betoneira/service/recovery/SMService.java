package betoneira.betoneira.service.recovery;

import betoneira.betoneira.model.recovery.NotificacaoSMS;

public class SMService extends DecoratorService{

    private final NotificacaoSMS nsms;

    public SMService(NotificacaoService ns, NotificacaoSMS nsms){
        super(ns);
        this.nsms = nsms;
    }

    @Override
    public void enviaCodigo(String codigo){
        super.enviaCodigo(codigo);
        System.out.printf("Uau!! Enviamos um SMS para %s com o código %s !!", nsms.getTel(), codigo);
    }
    
}
