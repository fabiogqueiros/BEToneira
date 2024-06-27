package betoneira.betoneira.model.bank;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "transacao")

@NoArgsConstructor
public class Transacao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private int id;

    @Getter @Setter private String tipo;

    @Getter @Setter private float quantia;

    @Getter @Setter private String modo;


    public Transacao(String tipo, float quantia, String modo) {
        this.tipo = tipo;
        this.quantia = quantia;
        this.modo = modo;
    }

}
