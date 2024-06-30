package betoneira.betoneira.service.games;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Roleta extends Jogos{
    //private String cores[];
    //private Integer numeros[];
    private String corEscolhida;
    private int numeroEscolhido;
    protected Map<Integer, String> colorsNumbers;

    @Override
    public void iniciarJogo(){
        this.colorsNumbers = new HashMap<Integer, String>();
        colorsNumbers.put(1, "branco");//Respeitando o diagrama, porem disposto a mudancas
        colorsNumbers.put(2,"vermelho");
        //...
    }
    public int sorteia(){//Duvida real se como vai ser o tipo de retorno
        Random sort = new Random();
        int numero = sort.nextInt(colorsNumbers.size()) + 1;
        return numero;
    }


    public void addBilhete(String escolha){
        //corEscolhida = escolha;
        int numero = this.sorteia();
        String corEsc = colorsNumbers.get(numero);
        if(corEsc == escolha){
            float mul = calcularMultiplicador();
            System.out.println("Voce ganhou!");
        }
        System.out.println("Voce perdeu!");
        this.encerrarJogo();
    }
    public void addBilhete(int escolha){
        int numero = this.sorteia();
        if(numero == escolha){
            float mul = calcularMultiplicador();
            System.out.println("Voce ganhou!");
        }
        System.out.println("Voce perdeu!");
        this.encerrarJogo();
    }


    public void encerrarJogo(){
        corEscolhida = null;
        //numeroEscolhido = null;
        colorsNumbers = null;
        System.out.println("Encerrado o jogo!");
    }
    public float calcularMultiplicador(){
        this.multiplicador  = 1;//+ adicionar a propabilidade de ganhar
        return 1;
    }
}
