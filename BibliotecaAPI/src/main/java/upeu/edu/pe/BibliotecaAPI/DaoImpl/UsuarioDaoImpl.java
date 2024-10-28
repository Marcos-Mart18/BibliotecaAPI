package upeu.edu.pe.BibliotecaAPI.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.BibliotecaAPI.Dao.UsuarioDao;
import upeu.edu.pe.BibliotecaAPI.Entity.Rol;
import upeu.edu.pe.BibliotecaAPI.Entity.Usuario;
import upeu.edu.pe.BibliotecaAPI.Repository.RolRepository;
import upeu.edu.pe.BibliotecaAPI.Repository.UsuarioRepository;
@Component
public class UsuarioDaoImpl implements UsuarioDao {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired 
	private RolRepository rolRepository;
	@Override
	public Usuario create(Usuario u) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(u);
	}

	@Override
	public Usuario update(Usuario u) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(u);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		usuarioRepository.deleteById(id);
	}

	@Override
	public Usuario read(Long id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id).get();
	}

	@Override
	public List<Usuario> readAll() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario registarUsuarioRol(Long idUsuario, Long idRol) {
		// TODO Auto-generated method stub
		Usuario usu=usuarioRepository.findById(idUsuario).orElseThrow(()-> new RuntimeException("Usuario no encontrado con ID"+idUsuario));
		Rol ro=rolRepository.findById(idRol).orElseThrow(()->new RuntimeException("Rol con encontrado con ID"+idRol));
		
		usu.getRoles().add(ro);
		ro.getUsuarios().add(usu);
		
			
		
		return usuarioRepository.save(usu);
	}
 
}
