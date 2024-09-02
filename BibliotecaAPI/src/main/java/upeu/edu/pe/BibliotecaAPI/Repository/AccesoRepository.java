package upeu.edu.pe.BibliotecaAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upeu.edu.pe.BibliotecaAPI.Entity.Acceso;
@Repository
public interface AccesoRepository extends JpaRepository<Acceso, Long>{

}
