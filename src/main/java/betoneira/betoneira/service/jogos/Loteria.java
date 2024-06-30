package betoneira.betoneira.service.jogos;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import betoneira.betoneira.model.Aposta;
import betoneira.betoneira.service.ApostaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
public class Loteria extends Jogos{

    private LocalTime inicio;
    private LocalTime fim;
    private static Loteria loteria;
    private Map<Integer, List<Aposta>> bilhetes;//Nao defini ao certo a tipagem, mas deixar como lembrete de (Aposta, numero)
    private int[] numerosValidos;//Atualizar o diagrama de classes

    private Loteria(int qtdeNum, int minutes){//Completar a inicializacao dos atributos
        this.inicio = LocalTime.now();
        this.fim = this.inicio.plusMinutes(minutes);

        this.multiplicador = (float) 1.1;
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
        System.out.println("Inicio o jogo!");
    }
    public int sorteia(){
        Random sort = new Random();
        int num1 = sort.nextInt(numerosValidos.length) + 1;//Math.random(numerosValidos.length) + 1;// this.sorteio.sorteia(this.numerosValidos[0], this.numerosValidos[numerosValidos.length-1]);
        int num2 = sort.nextInt(numerosValidos.length) + 1;
        if(num1 == num2){
            if(num1 == 1) num2++;
            else num2--;
        }
        num1 = num1 * 100 + num2;
        return num1;
    }
    public void addObserver(Aposta aposta, int[] numero){//Adicionando observadores aqui
        if(numero.length == 2){//Foi passado dois numeros para aposta
            this.bilhetes.get(numero[1]);
            List<Aposta> temp = this.bilhetes.get(numero[2]);
            temp.add(aposta);
            this.bilhetes.put(numero[1], temp);
        }
        this.bilhetes.get(numero[0]);
        List<Aposta> temp = this.bilhetes.get(numero[1]);
        temp.add(aposta);
        this.bilhetes.put(numero[0], temp);
        this.multiplicador += this.calcularMultiplicador();//Atualizando o multiplicador
    }
    public int[] getNumerosValidos(){
        return this.numerosValidos;
    }

    public void encerrarJogo(){
        LocalTime now = LocalTime.now();
        //Uma checagem se chegou o minuto de fechar o sorteio
        if(now.isBefore(fim)) return;
        //Hora de checar os vencedores
        int numero = this.sorteia();
        String numeroStr = Integer.toString(numero);
        List<Aposta> verificado = new ArrayList<Aposta>();
        for(int i = 0;i<3;i++){
            this.bilhetes.forEach((key, value) -> {
                String valueStr = Integer.toString(key);
                for (Aposta apt : value) {
                    //Aposta ja recebeu o seu multiplicador
                    if(verificado.contains(apt)) continue;
                    verificado.add(apt);

                    if(numeroStr.contains(valueStr)){//Fazer talvez um tratamento de voltar o multiplicador relativo a cada aposta (desacoplando aposta de Loteria)
                        apt.encerrarAposta(this.multiplicador);
                    }
                    else apt.encerrarAposta(0);//Ta certo? Faz sentido?
                };
            });
        };
        Loteria.loteria = null;
        this.bilhetes = null;
        this.numerosValidos = null;
    }

    public float calcularMultiplicador(){
        return this.multiplicador * 10 / 100;//Ilustracao de um calculo de multiplicador
    }

}
