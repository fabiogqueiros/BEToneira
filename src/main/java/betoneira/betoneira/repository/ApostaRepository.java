package betoneira.betoneira.repository;

import betoneira.betoneira.model.Aposta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApostaRepository extends CrudRepository<Aposta, Integer>{

    List<Aposta> findAll();

    Aposta findById(int id);

    void delete(Aposta aposta);

    <temporaryAposta extends Aposta> temporaryAposta save(temporaryAposta aposta);


}



//public class ApostaService{
//
//    List<Aposta> findAll();
//
//    Aposta findById(int id);
//
//    void delete(Aposta aposta);
//
//    <temporaryAposta extends Aposta> temporaryAposta save(temporaryAposta aposta);
//
//
//}


