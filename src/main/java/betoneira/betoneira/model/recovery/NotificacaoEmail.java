package betoneira.betoneira.model.recovery;

public class NotificacaoEmail extends Notificacao{

    protected String email;

    public NotificacaoEmail(String email){

        this.email = email;
    }

    public void enviaCodigo(String codigo){

        System.out.println("Uau! Te enviamos um email !!");
    }
}