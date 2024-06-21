package betoneira.betoneira.sign.Autenticacao;

import betoneira.betoneira.sign.Requisicao;

public class ContextAutenticacao {
    private StateAutenticacao state;
    private boolean autenticado;//Nao sei se e mais necessario com o uso do padrao GoF State!!!!!

    
    ContextAutenticacao(StateAutenticacao stateInitial){
        this.state = stateInitial;
        //Implemnents Method
    }

    public void autenticaRequisicao(Requisicao req){
        this.state.autenticaRequisicao(req);
    }
    public void changeState(StateAutenticacao state){
        this.state = state;
        this.state.setContext(this);
    }
}
