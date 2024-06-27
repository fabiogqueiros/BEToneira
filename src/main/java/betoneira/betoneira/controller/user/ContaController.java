package betoneira.betoneira.controller.user;

import betoneira.betoneira.model.user.Conta;
import betoneira.betoneira.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody List<Conta> getContas() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Conta getContaById(@PathVariable int id) {
        return repository.findById(id);
    }

    @RequestMapping(value = "/nome", method = RequestMethod.GET)
    public @ResponseBody Conta getContaByNome(@RequestBody Conta conta) {
        Conta contaAtual = repository.findByNome(conta.getNome());
        if (contaAtual == null) {
            return null;
        } else {
            if (conta.getSenha().equals(contaAtual.getSenha())) {
                return contaAtual;
            }
            return null;
        }
    }



    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody Conta createConta(@RequestBody Conta conta) {
        return repository.save(conta);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public @ResponseBody Conta updateConta(@RequestBody Conta conta) {
        return repository.save(conta);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Conta deleteContaById(@PathVariable int id) {
        Conta conta = repository.findById(id);
        if (conta == null) {
            return null;
        } else {
            repository.delete(conta);
            return conta;
        }
    }



}
