package betoneira.betoneira.model.recovery;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Recuperacao {
    
    private final String login;

    @Setter
    private String codigo;

    public Recuperacao(String login){
        this.login = login;
    }


}
