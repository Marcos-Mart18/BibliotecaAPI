package upeu.edu.pe.BibliotecaAPI.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import upeu.edu.pe.BibliotecaAPI.Entity.Libro;
@Component
public interface LibroDao {
	Libro create(Libro l);
	Libro update(Libro l);
	void delete(Long id);
	Libro read(Long id);
	Libro registrarLibroAutor(Long idLibro, Long idAutor);
	List<Libro>readAll();
}
