//Aqui o usuario ainda nao foi verificado (nao autenticado)

package betoneira.betoneira.sign.Autenticacao;

import betoneira.betoneira.sign.Requisicao;

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
