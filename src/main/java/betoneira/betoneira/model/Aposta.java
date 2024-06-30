package betoneira.betoneira.model;

import betoneira.betoneira.model.games.Jogos;
import betoneira.betoneira.model.user.Conta;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name= "aposta")
@NoArgsConstructor
public class Aposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int id;

    @Getter
    @Setter
    private float quantia;

    @Getter
    @Setter
    private String tipoJogo;//E necessario?

    @ManyToOne
    @Getter
    @Setter
    private Conta conta;

    @Getter
    @Setter
    private float salto;

    @Getter
    @Setter
    private Date dataDaAposta;


    public Aposta(int id, float quantia, String tipoJogo, Conta conta, float salto){
        this.id = id;
        this.quantia = quantia;
        this.tipoJogo = tipoJogo;
        this.conta = conta;
        this.salto = salto;
        this.dataDaAposta = new Date();
    }






    public void iniciarJogo() {
      //  this.jogo.iniciarJogo();
        //Implement Method
    }

    public void encerrarAposta(double d) {//Mudei o tipo da variavel aqui, rever isso (somente para evitar erro no codigo)
        //Implemnents Method
    }

    private void calculaSaldo(float multiplicador) {
        //Implemnents Method
    }
}
