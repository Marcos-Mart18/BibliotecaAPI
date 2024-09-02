package upeu.edu.pe.BibliotecaAPI.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import upeu.edu.pe.BibliotecaAPI.Entity.DetallePrestamo;
@Service
public interface DetallePrestamoService {
	DetallePrestamo create(DetallePrestamo d);
	DetallePrestamo update(DetallePrestamo d);
	void delete(Long id);
	DetallePrestamo read(Long id);
	List<DetallePrestamo>readAll();
}
