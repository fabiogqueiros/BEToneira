package betoneira.betoneira.repository;

import betoneira.betoneira.model.user.Conta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContaRepository extends CrudRepository<Conta, Integer> {

    List<Conta> findAll();

    Conta findById(int id);

    void delete(Conta conta);

    <temporaryConta extends Conta> temporaryConta save(temporaryConta conta);

}