package betoneira.betoneira.model.games;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import betoneira.betoneira.model.Aposta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Loteria extends Jogos{
    private LocalTime inicio;
    private LocalTime fim;
    private static betoneira.betoneira.service.games.Loteria loteria;
    private Map<Integer, List<Aposta>> bilhetes;//Nao defini ao certo a tipagem, mas deixar como lembrete de (Aposta, numero)
    private int[] numerosValidos;//Atualizar o diagrama de classes

}
