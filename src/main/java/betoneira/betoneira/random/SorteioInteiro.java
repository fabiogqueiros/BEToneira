package betoneira.betoneira.random;

import betoneira.interfaces.InterfaceSorteio;
import java.util.Random;

public class SorteioInteiro implements InterfaceSorteio{
    Random random;
    public SorteioInteiro(){
        this.random = new Random();
    }
    public Object sorteia(Object inicio, Object fim){
        int ini = (int) inicio;
        int fi = (int) fim;
        int numero = this.random.nextInt(fi - ini);
        return numero;
    };
}
