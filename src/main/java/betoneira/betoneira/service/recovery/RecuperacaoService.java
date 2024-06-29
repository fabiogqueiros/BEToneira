package betoneira.betoneira.service.recovery;

import java.util.Map;

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
        String login = r.getLogin();

        NotificacaoService ns = new EmailService(new NotificacaoEmail(args.get(login)));

        if (options.get("sms")){
           ns = new SMService(ns, new NotificacaoSMS(args.get("sms")));
        }
        if (options.get("correio")){
            ns = new CorreioService(ns, new NotificacaoCorreio(args.get("correio")));
        }
        ns.enviaCodigo(r.getCodigo());
    }

    public boolean verificaCodigo(String codigo){
        return r.getCodigo().equals(codigo);
    }
}