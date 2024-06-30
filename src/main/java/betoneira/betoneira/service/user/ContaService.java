package betoneira.betoneira.service.user;

import betoneira.betoneira.model.user.Conta;
import betoneira.betoneira.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@Service
public class ContaService {


    @Autowired
    private ContaRepository repository;

    public List<Conta> getContas() {
        return repository.findAll();
    }


    public Conta getContaById(int id) {
        return repository.findById(id);
    }

    public Boolean authenticateConta(String nome,String senha) {
        Conta contaAtual = repository.findByNome(nome);
        if (contaAtual == null) {
            return false;
        } else {
            if (contaAtual.getSenha().equals(senha)) {
                return true;
            }
            return false;
        }
    }

    public Boolean createConta(Conta conta) {
        List<Conta> todasContas = getContas();
        Iterator<Conta> iterador = todasContas.iterator();
        while(iterador.hasNext()){
            if(conta.getNome().equals(iterador.next().getNome())){
                return false;
            }
        }
        Conta con = repository.save(conta);
        if(con != null){
            return true;
        }
        else{
            return false;
        }
    }

    public Conta updateConta(Conta conta) {
        return repository.save(conta);
    }

    public Conta deleteContaById(int id) {
        Conta conta = repository.findById(id);
        if (conta == null) {
            return null;
        } else {
            repository.delete(conta);
            return conta;
        }
    }


}
