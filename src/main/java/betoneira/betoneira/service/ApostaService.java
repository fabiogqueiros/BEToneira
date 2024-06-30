package betoneira.betoneira.service;

import betoneira.betoneira.model.Aposta;
import betoneira.betoneira.repository.ApostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class ApostaService {
    @Autowired
    private ApostaRepository repository;

    public @ResponseBody List<Aposta> getApostas() {
        return repository.findAll();
    }

    public @ResponseBody Aposta getApostaById(@PathVariable int id) {
        return repository.findById(id);
    }

    public @ResponseBody Aposta createAposta(@RequestBody Aposta aposta) {
        return repository.save(aposta);
    }

    public @ResponseBody Aposta updateAposta(@RequestBody Aposta aposta) {
        return repository.save(aposta);
    }

    public @ResponseBody Aposta deleteApostaById(@PathVariable int id) {
        Aposta aposta = repository.findById(id);
        if (aposta == null) {
            return null;
        } else {
            repository.delete(aposta);
            return aposta;
        }
    }

    public void encerrarAposta(double d) {
        //Implements Method
    }

    private void calculaSaldo(float multiplicador) {
        //Implements Method
    }

}
