package upeu.edu.pe.BibliotecaAPI.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import upeu.edu.pe.BibliotecaAPI.Entity.LibroAutor;

@Component
public interface LibroAutorDao {
	LibroAutor create(LibroAutor lb);
	LibroAutor update(LibroAutor lb);
	void delete(Long id);
	LibroAutor read(Long id);
	List<LibroAutor>readAll();
}
