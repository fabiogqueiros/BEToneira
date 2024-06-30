package betoneira.betoneira.model.games;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class Roleta extends Jogos{
    private String corEscolhida;
    private int numeroEscolhido;
    protected Map<Integer, String> colorsNumbers;

}
