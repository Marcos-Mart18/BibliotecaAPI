package upeu.edu.pe.BibliotecaAPI.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.BibliotecaAPI.Dao.LectorDao;
import upeu.edu.pe.BibliotecaAPI.Entity.Lector;
import upeu.edu.pe.BibliotecaAPI.Service.LectorService;
@Service
public class LectorServiceImpl implements LectorService{
	
	@Autowired
	private LectorDao lectorDao;
	@Override
	public Lector create(Lector le) {
		// TODO Auto-generated method stub
		return lectorDao.create(le);
	}

	@Override
	public Lector update(Lector le) {
		// TODO Auto-generated method stub
		return lectorDao.update(le);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		lectorDao.delete(id);
	}

	@Override
	public Lector read(Long id) {
		// TODO Auto-generated method stub
		return lectorDao.read(id);
	}

	@Override
	public List<Lector> readAll() {
		// TODO Auto-generated method stub
		return lectorDao.readAll();
	}

}
