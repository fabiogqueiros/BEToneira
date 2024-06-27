package betoneira.betoneira.model.games;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

public class Aviao extends Jogos{
    private Integer tempo;
    private String estado;
    private float multiplicadorAtual;

    
    //@Override
    public void iniciarJogo(){
        //Implement Method
    }
    public void parar(){
        //Implemnents Method
    }
    private void aviaoSobe(){//No diagrama esta como publico, nao acho que deve ser isso
        //Implements Method
    }
    private void aviaoCrash(){
        //Implements Method
    }
    public void encerrarJogo(){
        //Implements Method
    }
    public Integer calcularMultiplicador(){
        //Implements Method
        return 1;
    }
}
