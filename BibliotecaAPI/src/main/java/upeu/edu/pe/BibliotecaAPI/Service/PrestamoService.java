package upeu.edu.pe.BibliotecaAPI.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import upeu.edu.pe.BibliotecaAPI.Entity.Prestamo;
@Service
public interface PrestamoService {
	Prestamo create(Prestamo p);
	Prestamo update(Prestamo p);
	void delete(Long id);
	Prestamo read(Long id);
	List<Prestamo>readALL();
}
