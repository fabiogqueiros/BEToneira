package betoneira.betoneira.recovery;

import betoneira.interfaces.InterfaceRecuperacao;

public class Recuperacao implements InterfaceRecuperacao{
    private String email;
    private int codigo;
    
    
    public void enviarEmail(){};
    public void gerarCodigo(){};
    public void confirmarCodigo(String codigo){};
}
