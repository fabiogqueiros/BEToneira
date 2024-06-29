package betoneira.betoneira.model.recovery;

public class NotificacaoCorreio extends DecoratorBase{
    
    private String endereco;

    public NotificacaoCorreio(Notificacao n, String endereco){
        super(n);
        this.endereco = endereco;
    }

    @Override
    public void enviaCodigo(String codigo){
        super.enviaCodigo(codigo);
        System.out.println("Uau! Te enviamos um sedex com o código");
    }
}
