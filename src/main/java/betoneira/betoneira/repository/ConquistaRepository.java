package betoneira.betoneira.repository;

import betoneira.betoneira.model.user.Conquista;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConquistaRepository extends CrudRepository<Conquista, Integer> {

    List<Conquista> findAll();

    Conquista findById(String id);

    void delete(Conquista conquista);

    <temporaryConquista extends Conquista> temporaryConquista save(temporaryConquista conquista);

}