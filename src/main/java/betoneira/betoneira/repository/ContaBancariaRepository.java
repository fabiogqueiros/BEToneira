package betoneira.betoneira.repository;

import betoneira.betoneira.model.bank.ContaBancaria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContaBancariaRepository extends CrudRepository<ContaBancaria, Integer> {

    List<ContaBancaria> findAll();

    ContaBancaria findById(int id);

    void delete(ContaBancaria contaBancaria);

    <temporaryContaBancaria extends ContaBancaria> temporaryContaBancaria save(temporaryContaBancaria contaBancaria);

}