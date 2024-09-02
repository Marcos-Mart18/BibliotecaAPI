package upeu.edu.pe.BibliotecaAPI.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.BibliotecaAPI.Dao.UsuarioRolDao;
import upeu.edu.pe.BibliotecaAPI.Entity.UsuarioRol;
import upeu.edu.pe.BibliotecaAPI.Repository.UsuarioRolRepository;
@Component
public class UsuarioRolDaoImpl implements UsuarioRolDao{
	@Autowired
	private UsuarioRolRepository usuarioRolRepository;
	@Override
	public UsuarioRol create(UsuarioRol ur) {
		// TODO Auto-generated method stub
		return usuarioRolRepository.save(ur);
	}

	@Override
	public UsuarioRol update(UsuarioRol ur) {
		// TODO Auto-generated method stub
		return usuarioRolRepository.save(ur);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		usuarioRolRepository.deleteById(id);
	}

	@Override
	public UsuarioRol read(Long id) {
		// TODO Auto-generated method stub
		return usuarioRolRepository.findById(id).get();
	}

	@Override
	public List<UsuarioRol> readAll() {
		// TODO Auto-generated method stub
		return usuarioRolRepository.findAll();
	}

}
