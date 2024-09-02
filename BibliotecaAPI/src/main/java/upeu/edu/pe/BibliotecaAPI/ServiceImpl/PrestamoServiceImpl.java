package upeu.edu.pe.BibliotecaAPI.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.BibliotecaAPI.Dao.PrestamoDao;
import upeu.edu.pe.BibliotecaAPI.Entity.Prestamo;
import upeu.edu.pe.BibliotecaAPI.Service.PrestamoService;

@Service
public class PrestamoServiceImpl implements PrestamoService {
	@Autowired
	private PrestamoDao prestamoDao;
	@Override
	public Prestamo create(Prestamo p) {
		// TODO Auto-generated method stub
		return prestamoDao.create(p);
	}

	@Override
	public Prestamo update(Prestamo p) {
		// TODO Auto-generated method stub
		return prestamoDao.update(p);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		prestamoDao.delete(id);
	}

	@Override
	public Prestamo read(Long id) {
		// TODO Auto-generated method stub
		return prestamoDao.read(id);
	}

	@Override
	public List<Prestamo> readALL() {
		// TODO Auto-generated method stub
		return prestamoDao.readALL();
	}

}
