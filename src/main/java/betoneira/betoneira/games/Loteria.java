package betoneira.betoneira.games;

import java.sql.Date;
import java.util.List;

import betoneira.betoneira.Aposta;
import betoneira.betoneira.random.SorteioInteiro;
import betoneira.interfaces.InterfaceSorteio;

public class Loteria extends Jogos{
    private Date inicio;
    private Date fim;
    private static Loteria loteria;
    private List<Aposta> bilhetes;//Nao defini ao certo a tipagem, mas deixar como lembrete de (Aposta, numero)
    private InterfaceSorteio sorteio;


    public static Loteria getCurrentLoteria(){
        if(loteria == null){
            loteria = new Loteria();
        }
        return loteria;
    }
    //@Override
    public void iniciarJogo(){
        this.sorteio = new SorteioInteiro();
        //Implement Method
    }
    public int sorteia(){//Acho que aqui vai virar uma funcao void, levado em conta o padrao GoF Observer

        int numero = (int) this.sorteio.sorteia(1, 2);
        for (Aposta apt : this.bilhetes) {
            apt.encerrarAposta(numero);
            //Implement Method
        };
        return 1;
    }
    public void addBilhetes(Aposta aposta, int numero){//Adicionando observadores aqui
        this.bilhetes.add(aposta);//Fazer a logica ainda de escolher o numero
        //Implements Method
    }
    public int[] getNumerosValidos(){
        //Implement Method
        return new int[1];
    }
    public void encerrarJogo(){
        //Implements Method
    }

}
