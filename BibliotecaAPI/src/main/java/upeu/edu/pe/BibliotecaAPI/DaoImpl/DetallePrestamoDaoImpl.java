package upeu.edu.pe.BibliotecaAPI.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.BibliotecaAPI.Dao.DetallePrestamoDao;
import upeu.edu.pe.BibliotecaAPI.Entity.DetallePrestamo;
import upeu.edu.pe.BibliotecaAPI.Repository.DetallePrestamoRepository;
@Component
public class DetallePrestamoDaoImpl implements DetallePrestamoDao {

	@Autowired
	private DetallePrestamoRepository detallePrestamoRepository;
	@Override
	public DetallePrestamo create(DetallePrestamo d) {
		// TODO Auto-generated method stub
		return detallePrestamoRepository.save(d);
	}

	@Override
	public DetallePrestamo update(DetallePrestamo d) {
		// TODO Auto-generated method stub
		return detallePrestamoRepository.save(d);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		detallePrestamoRepository.deleteById(id);
	}

	@Override
	public DetallePrestamo read(Long id) {
		// TODO Auto-generated method stub
		return detallePrestamoRepository.findById(id).get();
	}

	@Override
	public List<DetallePrestamo> readAll() {
		// TODO Auto-generated method stub
		return detallePrestamoRepository.findAll();
	}

}
