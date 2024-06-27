package betoneira.betoneira.controller.bank;

import betoneira.betoneira.model.bank.ContaBancaria;
import betoneira.betoneira.repository.ContaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contaBancaria")
public class ContaBancariaController {

    @Autowired
    private ContaBancariaRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody List<ContaBancaria> getContasBancarias() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody ContaBancaria getContaBancariaById(@PathVariable int id) {
        return repository.findById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody ContaBancaria createContaBancaria(@RequestBody ContaBancaria contaBancaria) {
        return repository.save(contaBancaria);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public @ResponseBody ContaBancaria updateContaBancaria(@RequestBody ContaBancaria contaBancaria) {
        return repository.save(contaBancaria);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody ContaBancaria deleteContaBancariaById(@PathVariable int id) {
        ContaBancaria contaBancaria = repository.findById(id);
        if (contaBancaria == null) {
            return null;
        } else {
            repository.delete(contaBancaria);
            return contaBancaria;
        }
    }



}
