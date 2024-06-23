package betoneira.betoneira.random;

import betoneira.interfaces.InterfaceSorteio;
import java.util.Random;

public class SorteioInteiro implements InterfaceSorteio{
    Random random;
    public SorteioInteiro(){
        this.random = new Random();
    }
    public Object sorteia(Object inicio, Object fim){
        Integer ini = (Integer) inicio;
        Integer fi = (Integer) fim;
        Integer numero = this.random.nextInt(fi - ini);
        return numero;
    };
}
