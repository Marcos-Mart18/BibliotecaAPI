package upeu.edu.pe.BibliotecaAPI.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.BibliotecaAPI.Dao.SeccionDao;
import upeu.edu.pe.BibliotecaAPI.Entity.Seccion;
import upeu.edu.pe.BibliotecaAPI.Service.SeccionService;
@Service
public class SeccionServiceImpl implements SeccionService{
	@Autowired
	private SeccionDao seccionDao;
	@Override
	public Seccion create(Seccion s) {
		// TODO Auto-generated method stub
		return  seccionDao.create(s);
	}

	@Override
	public Seccion update(Seccion s) {
		// TODO Auto-generated method stub
		return seccionDao.update(s);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		seccionDao.delete(id);
	}

	@Override
	public Seccion read(Long id) {
		// TODO Auto-generated method stub
		return seccionDao.read(id);
	}

	@Override
	public List<Seccion> readAll() {
		// TODO Auto-generated method stub
		return seccionDao.readAll();
	}

}
