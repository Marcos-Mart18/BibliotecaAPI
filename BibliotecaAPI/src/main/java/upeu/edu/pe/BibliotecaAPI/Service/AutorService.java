package upeu.edu.pe.BibliotecaAPI.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import upeu.edu.pe.BibliotecaAPI.Entity.Autor;

@Service
public interface AutorService {
	Autor create(Autor a);
	Autor update(Autor a);
	void delete(Long id);
	Autor read(Long id);
	List<Autor>readAll();
}
