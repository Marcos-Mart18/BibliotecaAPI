package upeu.edu.pe.BibliotecaAPI.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.BibliotecaAPI.Dao.UsuarioRolDao;
import upeu.edu.pe.BibliotecaAPI.Entity.UsuarioRol;
import upeu.edu.pe.BibliotecaAPI.Service.UsuarioRolService;

@Service
public class UsuarioRolServiceImpl implements UsuarioRolService {
	@Autowired
	private UsuarioRolDao usuarioRolDao;
	@Override
	public UsuarioRol create(UsuarioRol ur) {
		// TODO Auto-generated method stub
		return usuarioRolDao.create(ur);
	}

	@Override
	public UsuarioRol update(UsuarioRol ur) {
		// TODO Auto-generated method stub
		return usuarioRolDao.update(ur);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		usuarioRolDao.delete(id);
	}

	@Override
	public UsuarioRol read(Long id) {
		// TODO Auto-generated method stub
		return usuarioRolDao.read(id);
	}

	@Override
	public List<UsuarioRol> readAll() {
		// TODO Auto-generated method stub
		return usuarioRolDao.readAll();
	}

}
