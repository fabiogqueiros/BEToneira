package betoneira.betoneira.model.recovery;

public class Recuperacao {
    
    private final String login;
    private String codigo;

    public Recuperacao(String login){
        this.login = login;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    public String getCodigo() {
        return codigo;
    }
    
    public String getLogin() {
        return login;
    }


}
