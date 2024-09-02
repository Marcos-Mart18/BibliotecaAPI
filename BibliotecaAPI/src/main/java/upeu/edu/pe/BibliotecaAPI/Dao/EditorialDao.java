package upeu.edu.pe.BibliotecaAPI.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import upeu.edu.pe.BibliotecaAPI.Entity.Editorial;

@Component
public interface EditorialDao {
	Editorial create(Editorial e);
	Editorial update(Editorial e);
	void delete(Long id);
	Editorial read(Long id);
	List<Editorial>readAll();
}
