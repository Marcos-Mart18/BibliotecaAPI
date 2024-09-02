package upeu.edu.pe.BibliotecaAPI.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import upeu.edu.pe.BibliotecaAPI.Entity.Prestamo;

@Component
public interface PrestamoDao {
	Prestamo create(Prestamo p);
	Prestamo update(Prestamo p);
	void delete(Long id);
	Prestamo read(Long id);
	List<Prestamo>readALL();
}
