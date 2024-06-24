package betoneira.betoneira.repository;

import betoneira.betoneira.model.user.Perfil;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PerfilRepository extends CrudRepository<Perfil, Integer> {

    List<Perfil> findAll();

    Perfil findById(String id);

    void delete(Perfil perfil);

    <temporaryPerfil extends Perfil> temporaryPerfil save(temporaryPerfil perfil);

}