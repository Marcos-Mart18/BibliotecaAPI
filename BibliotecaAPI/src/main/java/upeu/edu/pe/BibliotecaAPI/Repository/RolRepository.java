package upeu.edu.pe.BibliotecaAPI.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upeu.edu.pe.BibliotecaAPI.Entity.Rol;
@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{
	Optional<Rol> findByNombre(String nombre);
}
