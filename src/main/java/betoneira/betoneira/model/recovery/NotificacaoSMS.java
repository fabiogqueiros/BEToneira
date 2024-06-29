package betoneira.betoneira.model.recovery;

public class NotificacaoSMS extends DecoratorBase{
    
    String tel;

    public NotificacaoSMS(Notificacao n, String tel){
        super(n);
        this.tel = tel;
    }

    @Override
    public void enviaCodigo(String codigo){
        super.enviaCodigo(codigo);
        System.out.println("Uau!! Te enviamos um SMS !!");
    }
}
