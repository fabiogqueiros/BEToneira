package betoneira.betoneira.service;

public class Aviao extends Jogos{
    private float tempo;
    private String estado;
    private float multiplicadorAtual;

    
    //@Override
    public void iniciarJogo(){
        this.estado = "Voando";
        //LocalTime now = 0.0;
        this.multiplicadorAtual = (float) 0.0;
    }
    public void parar(){
        System.out.println("Voce ganhou xxx moedas virtuais");
        this.encerrarJogo();
    }
    private void aviaoSobe(){//No diagrama esta como publico, nao acho que deve ser isso
        this.multiplicadorAtual = this.calcularMultiplicador();
        if(multiplicadorAtual > super.multiplicador){
            this.aviaoCrash();
        }
        this.tempo+=0.1;
    }
    private void aviaoCrash(){
        this.estado = "Caiu";
        System.out.println("O aviao "+estado+" pelo tempo de ");//adicioanar o tempo
        this.encerrarJogo();
    }
    public void encerrarJogo(){
        System.out.println("O jogo foi encerrado!");
    }
    public float calcularMultiplicador(){
        return this.multiplicadorAtual * 10/100;
    }

    /*public int sorteia(){
        Random sort = new Random();
        //int numero = sort.nextInt(2);
        int numero = sort.nextInt(60);
        if(numero > 30) return 1;
        return 0;
    }*/
}
