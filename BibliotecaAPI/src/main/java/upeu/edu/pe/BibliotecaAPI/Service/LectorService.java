package upeu.edu.pe.BibliotecaAPI.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import upeu.edu.pe.BibliotecaAPI.Entity.Lector;
@Service
public interface LectorService {
	Lector create(Lector le);
	Lector update(Lector le);
	void delete(Long id);
	Lector read(Long id);
	List<Lector>readAll();
}
