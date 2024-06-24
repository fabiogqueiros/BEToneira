package betoneira.betoneira.model.recovery;

import betoneira.betoneira.interfaces.InterfaceRecuperacao;

public class RecuperacaoDecoratorPhone implements InterfaceRecuperacao{
    private InterfaceRecuperacao recupera;
    private Integer codigo;
    private Integer phone;
    
    
    RecuperacaoDecoratorPhone(InterfaceRecuperacao recupera){//Exemplo de classe para estender novas funcionalidades para recuperar conta
        this.recupera = recupera;
    }

    @Override
    public void gerarCodigo(){
        recupera.gerarCodigo();
        //Implements method
    };
    @Override
    public void confirmarCodigo(String codigo){
        this.recupera.confirmarCodigo(codigo);
        //Implements method
    };
}
