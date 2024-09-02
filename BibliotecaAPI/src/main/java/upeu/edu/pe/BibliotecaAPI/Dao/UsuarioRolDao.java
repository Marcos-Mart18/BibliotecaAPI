package upeu.edu.pe.BibliotecaAPI.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import upeu.edu.pe.BibliotecaAPI.Entity.UsuarioRol;

@Component
public interface UsuarioRolDao {
	UsuarioRol create(UsuarioRol ur);
	UsuarioRol update(UsuarioRol ur);
	void delete(Long id);
	UsuarioRol read(Long id);
	List<UsuarioRol>readAll();
}
