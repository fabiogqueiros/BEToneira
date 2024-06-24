//Aqui o usuario ainda foi verificado (autenticado)

package betoneira.model;

public class AutenticacaoTrue extends StateAutenticacao{
    private Conquista.ContextAutenticacao context;

    
    AutenticacaoTrue(betoneira.model.ContextAutenticacao state){
        super(state);
        //state.
        //Implement Method
    }
    public void autenticaRequisicao(Requisicao req){
        //Implemnents Method
    }
    public void setContext(ContextAutenticacao context){
        this.context = context;
        //Implemnents Method
    };
}
