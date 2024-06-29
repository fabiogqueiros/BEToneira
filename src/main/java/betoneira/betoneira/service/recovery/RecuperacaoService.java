package betoneira.betoneira.service.recovery;

import java.util.Map;

import betoneira.betoneira.model.recovery.Notificacao;
import betoneira.betoneira.model.recovery.NotificacaoCorreio;
import betoneira.betoneira.model.recovery.NotificacaoEmail;
import betoneira.betoneira.model.recovery.NotificacaoSMS;
import betoneira.betoneira.model.recovery.Recuperacao;

public class RecuperacaoService {

    private final Recuperacao r;

    public RecuperacaoService(Recuperacao r){
        this.r = r;
    }

    private String geraCodigo(int seed){
        return String.valueOf(0 * seed + 1234);
    }

    public void enviaCodigo(int seed, Map<String, Boolean> options, Map<String, String> args){

        r.setCodigo(geraCodigo(seed));

        Notificacao n = new NotificacaoEmail(args.get(r.getLogin()));

        if (options.get("sms")){
            n = new NotificacaoSMS(n, args.get("sms"));
        }
        if (options.get("correio")){
            n = new NotificacaoCorreio(n, args.get("correio"));
        }
        n.enviaCodigo(r.getCodigo());
    }

    public boolean verificaCodigo(String codigo){
        return r.getCodigo().equals(codigo);
    }
}