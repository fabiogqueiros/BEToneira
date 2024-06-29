package betoneira.betoneira.service.jogos;

import java.util.List;

public class LoteriaPub{
    List<LoteriaSub> incritos;
    
    public void subscribe(LoteriaSub insc){
        incritos.add(insc);
    }
    public void unsubscribe(LoteriaSub insc){
        incritos.remove(insc);
    }
    public void notify(int value){
     for (LoteriaSub insc : incritos) {
        insc.update(value);
     }
    }
}
