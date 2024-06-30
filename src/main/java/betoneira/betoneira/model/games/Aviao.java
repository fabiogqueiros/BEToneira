package betoneira.betoneira.model.games;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Setter
@Getter
public class Aviao extends Jogos{
    private Integer tempo;
    private String estado;
    private float multiplicadorAtual;


}
