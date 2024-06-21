package betoneira.betoneira.sign.Autenticacao;

import betoneira.betoneira.sign.Requisicao;

public abstract class StateAutenticacao {
    private ContextAutenticacao state;

    
    StateAutenticacao(ContextAutenticacao state){
        this.state = state;
    }

    public abstract void setContext(ContextAutenticacao context);
    public abstract void autenticaRequisicao(Requisicao req);
    
}
