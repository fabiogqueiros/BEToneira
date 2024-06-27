package betoneira.betoneira.controller.bank;

import betoneira.betoneira.model.bank.Transacao;
import betoneira.betoneira.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody List<Transacao> getTransacoes() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Transacao getTransacaoById(@PathVariable int id) {
        return repository.findById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody Transacao createTransacao(@RequestBody Transacao transacao) {
        return repository.save(transacao);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public @ResponseBody Transacao updateTransacao(@RequestBody Transacao transacao) {
        return repository.save(transacao);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Transacao deleteTransacaoById(@PathVariable int id) {
        Transacao transacao = repository.findById(id);
        if (transacao == null) {
            return null;
        } else {
            repository.delete(transacao);
            return transacao;
        }
    }



}
