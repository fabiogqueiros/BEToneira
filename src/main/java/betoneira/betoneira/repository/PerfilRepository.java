package betoneira.betoneira.repository;

import betoneira.betoneira.model.user.Perfil;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerfilRepository extends CrudRepository<Perfil, Integer> {

    List<Perfil> findAll();

    Perfil findById(int id);

    void delete(Perfil perfil);

    <temporaryPerfil extends Perfil> temporaryPerfil save(temporaryPerfil perfil);

}