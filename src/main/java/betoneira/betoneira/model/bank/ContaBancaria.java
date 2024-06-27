package betoneira.betoneira.model.bank;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name="contaBancaria")
@NoArgsConstructor
public class ContaBancaria {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int id;

    @Getter @Setter
    private float saldo;

    @OneToMany @Getter @Setter
    private List<Transacao> historico;


    public void fazerTransacaoInterna(float saldo){
        //Implemnents Method
    }
    public void fazerDeposito(int idConta, float quantia){
        //Implemnents Method
    }
    public void fazerSaque(){//O retorno nao deve ser um inteiro, no caso de outra classe que chamou ela (como confirmacao)
        //Implemnents Method
    }
    public float consultarExtrato(int idConta){
        //Implemnents Method
        return this.saldo;
    }
    private float checarSaldo(){
        //Implemnents Method
        return this.saldo;
    }
    public void salvarTransacao(Transacao trsc){
        //Implemnents Method
    }
    private void adicionarSaldo(float quantia){
        //Implemnents Method
    }
    private void realizarPagamento(float quantia){
        //Implemnents Method
    }

}
