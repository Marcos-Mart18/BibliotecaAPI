package upeu.edu.pe.BibliotecaAPI.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import upeu.edu.pe.BibliotecaAPI.Entity.LibroAutor;

@Service
public interface LibroAutorService {
	LibroAutor create(LibroAutor lb);
	LibroAutor update(LibroAutor lb);
	void delete(Long id);
	LibroAutor read(Long id);
	List<LibroAutor>readAll();
}
