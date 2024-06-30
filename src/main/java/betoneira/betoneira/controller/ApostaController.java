package betoneira.betoneira.controller;

import betoneira.betoneira.model.Aposta;
import betoneira.betoneira.repository.ApostaRepository;
import betoneira.betoneira.service.ApostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aposta")

public class ApostaController {

    @Autowired
    private ApostaService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody List<Aposta> getApostas() {
        return service.getApostas();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Aposta getApostaById(@PathVariable int id) {
        return service.getApostaById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody Aposta createAposta(@RequestBody Aposta aposta) {
        return service.createAposta(aposta);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public @ResponseBody Aposta updateAposta(@RequestBody Aposta aposta) {
        return service.updateAposta(aposta);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Aposta deleteApostaById(@PathVariable int id) {
        return service.deleteApostaById(id);
    }





}
