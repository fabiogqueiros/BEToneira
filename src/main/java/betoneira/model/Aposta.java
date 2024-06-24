package betoneira.model;

public class Aposta {
    private float quantia;
    private Conquista.Jogos jogo;
    private String tipoJogo;//E necessario?
    private Conta conta;
    private float salto;


    public void iniciarJogo(){
        this.jogo.iniciarJogo();
        //Implement Method
    }
    public void encerrarAposta(double d){//Mudei o tipo da variavel aqui, rever isso (somente para evitar erro no codigo)
        //Implemnents Method
    }
    private void calculaSaldo(float multiplicador){
        //Implemnents Method
    }
}
