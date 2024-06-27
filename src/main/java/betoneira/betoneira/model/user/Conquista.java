package betoneira.betoneira.model.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "conquista")
@NoArgsConstructor
public class Conquista {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int id;

    @Getter @Setter
    private String titulo;

    @Getter @Setter
    private String descricao;

}
