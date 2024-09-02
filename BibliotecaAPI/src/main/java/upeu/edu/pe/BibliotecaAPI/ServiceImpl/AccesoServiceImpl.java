package upeu.edu.pe.BibliotecaAPI.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.BibliotecaAPI.Dao.AccesoDao;
import upeu.edu.pe.BibliotecaAPI.Entity.Acceso;
import upeu.edu.pe.BibliotecaAPI.Service.AccesoService;

@Service
public class AccesoServiceImpl implements AccesoService{
	@Autowired
	private AccesoDao accesoDao;
	@Override
	public Acceso create(Acceso ac) {
		// TODO Auto-generated method stub
		return accesoDao.create(ac);
	}

	@Override
	public Acceso update(Acceso ac) {
		// TODO Auto-generated method stub
		return accesoDao.update(ac);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		accesoDao.delete(id);
	}

	@Override
	public Acceso read(Long id) {
		// TODO Auto-generated method stub
		return accesoDao.read(id);
	}

	@Override
	public List<Acceso> readAll() {
		// TODO Auto-generated method stub
		return accesoDao.readAll();
	}

}
