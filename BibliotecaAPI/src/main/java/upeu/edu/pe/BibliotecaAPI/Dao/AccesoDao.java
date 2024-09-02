package upeu.edu.pe.BibliotecaAPI.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import upeu.edu.pe.BibliotecaAPI.Entity.Acceso;

@Component
public interface AccesoDao {
	Acceso create(Acceso ac);
	Acceso update(Acceso ac);
	void delete(Long id);
	Acceso read(Long id);
	List<Acceso>readAll();
}
