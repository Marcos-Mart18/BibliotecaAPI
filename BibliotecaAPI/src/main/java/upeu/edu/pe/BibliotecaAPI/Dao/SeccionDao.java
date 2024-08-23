package upeu.edu.pe.BibliotecaAPI.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import upeu.edu.pe.BibliotecaAPI.Entity.Seccion;
@Component
public interface SeccionDao {
	Seccion create(Seccion s);
	Seccion update(Seccion s);
	void delete(Long id);
	Seccion read(Long id);
	List<Seccion>readAll();
}
