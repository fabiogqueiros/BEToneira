package betoneira.betoneira.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Roleta extends Jogos{
    private String cores[];
    private Integer numeros[];
    private String corEscolhida;
    private int numeroEscolhido;
    protected Map<Integer, String> colorsNumbers;

    @Override
    public void iniciarJogo(){
        this.colorsNumbers = new HashMap<Integer, String>();
        //Adicionar as cores e numeros
    }
    public int sorteia(){//Duvida real se como vai ser o tipo de retorno
        Random sort = new Random();
        int numero = sort.nextInt(numeros.length) + 1;
        return numero;
    }
    public void encerrarJogo(){
        corEscolhida = null;
        //numeroEscolhido = null;
        colorsNumbers = null;
        System.out.println("Encerrado o jogo!");
    }
    public float calcularMultiplicador(){
        //Nao sei como vai decidir as probabilidades para calcular multiplicador
        return 1;
    }
}
