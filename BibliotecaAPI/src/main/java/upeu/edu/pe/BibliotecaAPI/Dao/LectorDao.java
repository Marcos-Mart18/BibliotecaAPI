package upeu.edu.pe.BibliotecaAPI.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import upeu.edu.pe.BibliotecaAPI.Entity.Lector;

@Component
public interface LectorDao {
	Lector create(Lector le);
	Lector update(Lector le);
	void delete(Long id);
	Lector read(Long id);
	List<Lector>readAll();
}
