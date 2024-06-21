//Aqui o usuario ainda foi verificado (autenticado)

package betoneira.betoneira.sign.Autenticacao;

import betoneira.betoneira.sign.Requisicao;

public class AutenticacaoTrue extends StateAutenticacao{
    private ContextAutenticacao context;

    
    AutenticacaoTrue(ContextAutenticacao state){
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
