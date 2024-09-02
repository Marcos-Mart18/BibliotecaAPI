package upeu.edu.pe.BibliotecaAPI.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import upeu.edu.pe.BibliotecaAPI.Entity.DetallePrestamo;

@Component
public interface DetallePrestamoDao {
	DetallePrestamo create(DetallePrestamo d);
	DetallePrestamo update(DetallePrestamo d);
	void delete(Long id);
	DetallePrestamo read(Long id);
	List<DetallePrestamo>readAll();
}
