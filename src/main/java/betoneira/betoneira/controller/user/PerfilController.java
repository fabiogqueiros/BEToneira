package betoneira.betoneira.controller.user;

import betoneira.betoneira.model.user.Perfil;
import betoneira.betoneira.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    private PerfilRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody List<Perfil> getPerfis() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Perfil getPerfilById(@PathVariable int id) {
        return repository.findById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody Perfil createPerfil(@RequestBody Perfil perfil) {
        return repository.save(perfil);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public @ResponseBody Perfil updatePerfil(@RequestBody Perfil perfil) {
        return repository.save(perfil);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Perfil deletePerfilById(@PathVariable int id) {
        Perfil perfil = repository.findById(id);
        if (perfil == null) {
            return null;
        } else {
            repository.delete(perfil);
            return perfil;
        }
    }



}
