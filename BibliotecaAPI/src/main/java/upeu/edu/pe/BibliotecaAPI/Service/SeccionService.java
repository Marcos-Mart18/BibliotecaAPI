package upeu.edu.pe.BibliotecaAPI.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import upeu.edu.pe.BibliotecaAPI.Entity.Seccion;
@Service
public interface SeccionService {
	Seccion create(Seccion s);
	Seccion update(Seccion s);
	void delete(Long id);
	Seccion read(Long id);
	List<Seccion>readAll();
}
