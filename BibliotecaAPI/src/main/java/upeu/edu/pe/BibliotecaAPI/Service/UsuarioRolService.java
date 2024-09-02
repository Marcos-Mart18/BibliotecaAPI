package upeu.edu.pe.BibliotecaAPI.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import upeu.edu.pe.BibliotecaAPI.Entity.UsuarioRol;

@Service
public interface UsuarioRolService {
	UsuarioRol create(UsuarioRol ur);
	UsuarioRol update(UsuarioRol ur);
	void delete(Long id);
	UsuarioRol read(Long id);
	List<UsuarioRol>readAll();
}
