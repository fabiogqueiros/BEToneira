package betoneira.betoneira.model.recovery;

public class RecuperacaoSMS extends DecoratorBase{

    private Integer phone;
    
    public RecuperacaoSMS(Recuperacao r, Integer tel){//Exemplo de classe para estender novas funcionalidades para recuperar conta
        super(r);
    }
}
