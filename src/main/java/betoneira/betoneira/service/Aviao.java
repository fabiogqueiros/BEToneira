package betoneira.betoneira.service;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

public class Aviao extends Jogos{
    private int tempo;
    private String estado;
    private float multiplicadorAtual;

    
    //@Override
    public void iniciarJogo(){
        this.estado = "Voando";
        //LocalTime now = 0.0;
        this.multiplicadorAtual = (float) 0.0;
    }
    public void parar(){
        this.encerrarJogo();
    }
    private void aviaoSobe(){//No diagrama esta como publico, nao acho que deve ser isso
        this.multiplicadorAtual = this.calcularMultiplicador();
        if(multiplicadorAtual > super.multiplicador){
            this.aviaoCrash();
        }
    }
    private void aviaoCrash(){
        this.estado = "Caiu";
        this.encerrarJogo();
    }
    public void encerrarJogo(){
        //:(
    }
    public float calcularMultiplicador(){
        return this.multiplicadorAtual * 10/100;
    }
}
