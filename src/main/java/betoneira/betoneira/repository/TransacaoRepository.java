package betoneira.betoneira.repository;

import betoneira.betoneira.model.bank.Transacao;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransacaoRepository extends CrudRepository<Transacao, Integer> {

    List<Transacao> findAll();

    Transacao findById(int id);

    void delete(Transacao transacao);

    <temporaryTransacao extends Transacao> temporaryTransacao save(temporaryTransacao transacao);

}