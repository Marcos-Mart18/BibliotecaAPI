package upeu.edu.pe.BibliotecaAPI.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.BibliotecaAPI.Dao.AccesoRolDao;
import upeu.edu.pe.BibliotecaAPI.Entity.AccesoRol;
import upeu.edu.pe.BibliotecaAPI.Service.AccesoRolService;

@Service
public class AccesoRolServiceImpl implements AccesoRolService {
	@Autowired
	private AccesoRolDao accesoRolDao;
	@Override
	public AccesoRol create(AccesoRol ar) {
		// TODO Auto-generated method stub
		return accesoRolDao.create(ar);
	}

	@Override
	public AccesoRol update(AccesoRol ar) {
		// TODO Auto-generated method stub
		return accesoRolDao.update(ar);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		accesoRolDao.delete(id);
	}

	@Override
	public AccesoRol read(Long id) {
		// TODO Auto-generated method stub
		return accesoRolDao.read(id);
	}

	@Override
	public List<AccesoRol> readAll() {
		// TODO Auto-generated method stub
		return accesoRolDao.readAll();
	}

}
