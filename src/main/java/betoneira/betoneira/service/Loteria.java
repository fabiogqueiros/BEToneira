package betoneira.betoneira.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import betoneira.betoneira.interfaces.InterfaceSorteio;
import betoneira.betoneira.model.Aposta;
import betoneira.betoneira.model.random.SorteioInteiro;

public class Loteria extends Jogos{
    private int inicio;
    private LocalTime fim;
    private static Loteria loteria;
    private Map<Integer, List<Aposta>> bilhetes;//Nao defini ao certo a tipagem, mas deixar como lembrete de (Aposta, numero)
    private InterfaceSorteio sorteio;
    private int[] numerosValidos;//Atualizar o diagrama de classes

    private Loteria(int qtdeNum, int minutes){//Completar a inicializacao dos atributos
        LocalTime now = LocalTime.now();
        inicio = now.getMinute();
        fim = now.plusMinutes(minutes);

        this.multiplicador = 1;
        this.numerosValidos = new int[qtdeNum];
        this.bilhetes = new HashMap<Integer, List<Aposta>>();
        for(int i = 0; i < qtdeNum;i++){
            this.numerosValidos[i] = i+1;
            this.bilhetes.put(i+1, new ArrayList<Aposta>());
        }
        
    }
    public static Loteria getCurrentLoteria(){
        if(loteria == null){
            loteria = new Loteria(60, 2);//Qtde de numeros para se apostar, e tempo para apostar
        }
        return loteria;
    }
    //@Override
    public void iniciarJogo(){
        this.sorteio = new SorteioInteiro();
    }
    public int sorteia(){
        Random sort = new Random();
        int numero = sort.nextInt(numerosValidos.length) + 1;//Math.random(numerosValidos.length) + 1;// this.sorteio.sorteia(this.numerosValidos[0], this.numerosValidos[numerosValidos.length-1]);
        return numero;
    }
    public void addBilhetes(Aposta aposta, int numero){//Adicionando observadores aqui
        List<Aposta> temp = this.bilhetes.get(numero);
        temp.add(aposta);
        this.bilhetes.put(numero, temp);
        this.multiplicador += this.calcularMultiplicador();//Atualizando o multiplicador
    }
    public int[] getNumerosValidos(){
        return this.numerosValidos;
    }

    public void encerrarJogo(){
        LocalTime now = LocalTime.now();
        int temp = now.getMinute();
        //Uma checagem se chegou o minuto de fechar o sorteio
        if(temp != this.fim.getMinute()) return;

        int numero = this.sorteia();
        this.bilhetes.forEach((key, value) -> {
            for (Aposta apt : value) {
                if(key == numero){//Fazer talvez um tratamento de voltar o multiplicador relativo a cada aposta (desacoplando aposta de Loteria)
                    apt.encerrarAposta(this.multiplicador);
                }
                else apt.encerrarAposta(0);
        };});
        Loteria.loteria = null;
        this.bilhetes = null;
        this.sorteio = null;
        this.numerosValidos = null;
    }

    public float calcularMultiplicador(){
        return this.multiplicador * 10 / 100;//Ilustracao de um calculo de multiplicador
    }

}
