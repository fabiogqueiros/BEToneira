package betoneira.betoneira.model.bank;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name= "transacao")

@NoArgsConstructor
public class Transacao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private int id;

    @Getter @Setter private String tipo;

    @Getter @Setter private float quantia;

    @Getter @Setter private String modo;

    @Getter @Setter private String nome;

    @Getter @Setter private LocalDate dataTransacao;


    public Transacao(String tipo, float quantia, String nome, String modo) {
        this.tipo = tipo;
        this.quantia = quantia;
        this.nome = nome;
        this.modo = modo;
        this.dataTransacao = LocalDate.now();
    }

}
