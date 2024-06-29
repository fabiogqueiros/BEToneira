package betoneira.betoneira.service.recovery;

import betoneira.betoneira.model.recovery.NotificacaoEmail;

public class EmailService extends NotificacaoService{

    private final NotificacaoEmail n;

    public EmailService(NotificacaoEmail n){
        this.n = n;
    }
    
    @Override
    public void enviaCodigo(String codigo){
        System.out.printf("Uau! Enviamos um email para %s com o código %s !!", n.getEmail(), codigo);
    }
}