package upeu.edu.pe.BibliotecaAPI.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import upeu.edu.pe.BibliotecaAPI.Entity.Rol;

@Component
public interface RolDao {
	Rol create(Rol r);
	Rol update(Rol r);
	void delete(Long id);
	Rol read(Long id);
	List<Rol>readAll();
}
