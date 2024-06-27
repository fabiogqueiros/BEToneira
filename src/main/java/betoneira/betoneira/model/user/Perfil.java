package betoneira.betoneira.model.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name= "perfil")
@NoArgsConstructor
public class Perfil {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int id;

    @Getter @Setter
    private String nomeConta;

    @OneToMany @Getter @Setter
    private List<Conquista> conquistas;

}
