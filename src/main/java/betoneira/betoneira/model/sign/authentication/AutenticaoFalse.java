//Aqui o usuario ainda nao foi verificado (nao autenticado)

package betoneira.betoneira.model.sign.authentication;

import betoneira.betoneira.model.sign.Requisicao;

public class AutenticaoFalse extends StateAutenticacao{
    private ContextAutenticacao context;

    
    AutenticaoFalse(ContextAutenticacao state){
        super(state);
        //state.
        //Implement Method
    }
    @Override
    public void autenticaRequisicao(Requisicao req){
        //Implemnents Method
    }
    @Override
    public void setContext(ContextAutenticacao context){
        //Implemnents Method
        this.context = context;
    };
}
