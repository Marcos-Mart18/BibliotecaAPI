package upeu.edu.pe.BibliotecaAPI.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import upeu.edu.pe.BibliotecaAPI.Entity.Usuario;
@Service
public interface UsuarioService {
	Usuario create(Usuario u);
	Usuario update(Usuario u);
	void delete(Long id);
	Usuario read(Long id);
	Usuario registarUsuarioRol(Long idUsuario,Long idRol);
	List<Usuario>readAll();
}
