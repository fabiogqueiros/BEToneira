package betoneira.betoneira.repository;

import betoneira.betoneira.model.bank.ContaBancaria;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContaBancariaRepository extends CrudRepository<ContaBancaria, Integer> {

    List<ContaBancaria> findAll();

    ContaBancaria findById(String id);

    void delete(ContaBancaria contaBancaria);

    <temporaryContaBancaria extends ContaBancaria> temporaryContaBancaria save(temporaryContaBancaria contaBancaria);

}