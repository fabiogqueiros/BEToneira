package betoneira.betoneira.model.user;

import betoneira.betoneira.model.Aposta;
import betoneira.betoneira.model.sign.Requisicao;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name= "conta")
@NoArgsConstructor
public class Conta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int id;

    @Getter @Setter
    private String username;

    @Getter @Setter
    private String email;

    @OneToMany @Getter @Setter
    private List<Aposta> historico;

    
    public void receberRequisicao(Requisicao req){
        //Implemnents Method
    }
    public void consolidarAposta(float saldo){
        //Implemnents Method
    }
}
