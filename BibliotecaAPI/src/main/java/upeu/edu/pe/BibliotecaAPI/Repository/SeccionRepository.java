package upeu.edu.pe.BibliotecaAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upeu.edu.pe.BibliotecaAPI.Entity.Seccion;

@Repository
public interface SeccionRepository extends JpaRepository<Seccion, Long> {

}
