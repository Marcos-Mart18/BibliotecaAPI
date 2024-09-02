package upeu.edu.pe.BibliotecaAPI.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.BibliotecaAPI.Dao.DetallePrestamoDao;
import upeu.edu.pe.BibliotecaAPI.Entity.DetallePrestamo;
import upeu.edu.pe.BibliotecaAPI.Service.DetallePrestamoService;

@Service
public class DetallePrestamoServiceImpl implements DetallePrestamoService{
	@Autowired
	private DetallePrestamoDao detallePrestamoDao;
	@Override
	public DetallePrestamo create(DetallePrestamo d) {
		// TODO Auto-generated method stub
		return detallePrestamoDao.create(d);
	}

	@Override
	public DetallePrestamo update(DetallePrestamo d) {
		// TODO Auto-generated method stub
		return detallePrestamoDao.update(d);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		detallePrestamoDao.delete(id);
	}

	@Override
	public DetallePrestamo read(Long id) {
		// TODO Auto-generated method stub
		return detallePrestamoDao.read(id);
	}

	@Override
	public List<DetallePrestamo> readAll() {
		// TODO Auto-generated method stub
		return detallePrestamoDao.readAll();
	}

}
