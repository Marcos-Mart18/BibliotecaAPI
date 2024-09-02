package upeu.edu.pe.BibliotecaAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upeu.edu.pe.BibliotecaAPI.Entity.DetallePrestamo;
@Repository
public interface DetallePrestamoRepository extends JpaRepository<DetallePrestamo, Long>{

}
