package betoneira.betoneira.model.recovery;

public class RecuperacaoBase extends Recuperacao{
    
    private String email;
    
    public RecuperacaoBase(String email){
        this.email = email;
    }
    
    @Override
    public void enviaCodigo(String codigo){
        System.out.println("Estamos te enviando um email !!");
    }

    @Override
    public void enviarEmail() {
        super.enviarEmail();
    }

    


}
