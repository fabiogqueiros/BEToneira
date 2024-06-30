package betoneira.betoneira.controller.user;

import betoneira.betoneira.model.user.Conta;
import betoneira.betoneira.repository.ContaRepository;
import betoneira.betoneira.service.user.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody List<Conta> getContas() {
        return service.getContas();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Conta getContaById(@PathVariable int id) {
        return service.getContaById(id);
    }

    @RequestMapping(value = "/nome", params = {"nome", "senha"}, method = RequestMethod.GET)
    public @ResponseBody Boolean authenticateConta(@RequestParam("nome") String nome, @RequestParam("senha") String senha) {
        return service.authenticateConta(nome, senha);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody Boolean createConta(@RequestBody Conta conta) {
        return service.createConta(conta);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public @ResponseBody Conta updateConta(@RequestBody Conta conta) {
        return service.updateConta(conta);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Conta deleteContaById(@PathVariable int id) {
        return deleteContaById(id);
    }



}
