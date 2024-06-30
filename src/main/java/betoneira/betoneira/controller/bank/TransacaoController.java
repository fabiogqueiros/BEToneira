package betoneira.betoneira.controller.bank;

import betoneira.betoneira.model.bank.Transacao;
import betoneira.betoneira.service.bank.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody List<Transacao> getTransacoes() {
        return service.getTransacoes();
    }

    @RequestMapping(value="/nome/{nome}", method = RequestMethod.GET)
    public @ResponseBody List<Transacao> getTransacoesByNome(@PathVariable String nome){
        return service.getTransacoesByNome(nome);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Transacao getTransacaoById(@PathVariable int id) {
        return service.getTransacaoById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody void createTransacao(@RequestBody Transacao transacao) {
        service.createTransacao(transacao);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public @ResponseBody Transacao updateTransacao(@RequestBody Transacao transacao) {
        return service.updateTransacao(transacao);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Transacao deleteTransacaoById(@PathVariable int id) {
        return service.deleteTransacaoById(id);
    }

    @RequestMapping(value = "/filter", params = {"nome", "tipo", "dataInicio", "dataFim"}, method = RequestMethod.GET)
    public @ResponseBody String getTransacaoByNomeWithFilter(@RequestParam("nome") String nome,@RequestParam("tipo") int tipo ,@RequestParam("dataInicio") String inicio, @RequestParam("dataFim") String fim) {
        return service.getTransacaoByNomeWithFilter(nome, tipo, inicio, fim);
    }

}
