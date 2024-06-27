package betoneira.betoneira.controller.user;

import betoneira.betoneira.model.user.Conquista;
import betoneira.betoneira.repository.ConquistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conquista")
public class ConquistaController {

    @Autowired
    private ConquistaRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody List<Conquista> getConquistas() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Conquista getConquistaById(@PathVariable int id) {
        return repository.findById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody Conquista createConquista(@RequestBody Conquista conquista) {
        return repository.save(conquista);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public @ResponseBody Conquista updateConquista(@RequestBody Conquista conquista) {
        return repository.save(conquista);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Conquista deleteConquistaById(@PathVariable int id) {
        Conquista conquista = repository.findById(id);
        if (conquista == null) {
            return null;
        } else {
            repository.delete(conquista);
            return conquista;
        }
    }



}
