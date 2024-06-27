package betoneira.betoneira.repository;

import betoneira.betoneira.model.user.Conquista;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConquistaRepository extends CrudRepository<Conquista, Integer> {

    List<Conquista> findAll();

    Conquista findById(int id);

    void delete(Conquista conquista);

    <temporaryConquista extends Conquista> temporaryConquista save(temporaryConquista conquista);

}