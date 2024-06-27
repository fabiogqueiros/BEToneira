package betoneira.betoneira.controller;

import betoneira.betoneira.model.Aposta;
import betoneira.betoneira.repository.ApostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aposta")

public class ApostaController {

    @Autowired
    private ApostaRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody List<Aposta> getApostas() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Aposta getApostaById(@PathVariable int id) {
        return repository.findById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody Aposta createAposta(@RequestBody Aposta aposta) {
        return repository.save(aposta);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public @ResponseBody Aposta updateAposta(@RequestBody Aposta aposta) {
        return repository.save(aposta);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Aposta deleteApostaById(@PathVariable int id) {
        Aposta aposta = repository.findById(id);
        if (aposta == null) {
            return null;
        } else {
            repository.delete(aposta);
            return aposta;
        }
    }



}
