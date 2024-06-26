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
    @Column(name= "id")
    @Getter private int id;

    @Column(name= "tipo")
    @Getter @Setter private String tipo;

    @Column(name="quantia")
    @Getter @Setter private float quantia;

    @Column(name="modo")
    @Getter @Setter private String modo;


    public Transacao(String tipo, float quantia, String modo) {
        this.tipo = tipo;
        this.quantia = quantia;
        this.modo = modo;
    }

}
