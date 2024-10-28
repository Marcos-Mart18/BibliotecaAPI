package upeu.edu.pe.BibliotecaAPI.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import upeu.edu.pe.BibliotecaAPI.Entity.Libro;
@Service
public interface LibroService {
	Libro create(Libro l);
	Libro update(Libro l);
	void delete(Long id);
	Libro read(Long id);
	Libro registrarLibroAutor(Long idLibro, Long idAutor);
	List<Libro>readAll();
}
