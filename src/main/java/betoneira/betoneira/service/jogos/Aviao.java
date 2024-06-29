package betoneira.betoneira.service.jogos;
import java.util.Random;

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
        if(this.sorteia() == 0){//Aviao perdeu
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

    public int sorteia(){
        int numSort = 60;
        if(multiplicadorAtual > super.multiplicador /3 * 2) numSort = 10;//Diminuindo a chance de ganhar
        if(multiplicadorAtual > super.multiplicador /4 * 3) numSort = 8;
        
        Random sort = new Random();
        int numero = sort.nextInt(numSort);
        if(numero > 5) return 1;
        return 0;
    }

    public boolean consultaEstado(){
        if(estado == "caiu") return false;
        return true;
    }
}
