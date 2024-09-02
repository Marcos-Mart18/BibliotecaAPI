package upeu.edu.pe.BibliotecaAPI.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import upeu.edu.pe.BibliotecaAPI.Entity.Autor;
@Component
public interface AutorDao {
	Autor create(Autor a);
	Autor update(Autor a);
	void delete(Long id);
	Autor read(Long id);
	List<Autor>readAll();
}
