package upeu.edu.pe.BibliotecaAPI.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.BibliotecaAPI.Dao.PrestamoDao;
import upeu.edu.pe.BibliotecaAPI.Entity.Prestamo;
import upeu.edu.pe.BibliotecaAPI.Repository.PrestamoRepository;
@Component
public class PrestamoDaoImpl implements PrestamoDao{
	@Autowired
	private PrestamoRepository prestamoRepository;
	@Override
	public Prestamo create(Prestamo p) {
		// TODO Auto-generated method stub
		return prestamoRepository.save(p);
	}

	@Override
	public Prestamo update(Prestamo p) {
		// TODO Auto-generated method stub
		return prestamoRepository.save(p);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		prestamoRepository.deleteById(id);
	}

	@Override
	public Prestamo read(Long id) {
		// TODO Auto-generated method stub
		return prestamoRepository.findById(id).get();
	}

	@Override
	public List<Prestamo> readALL() {
		// TODO Auto-generated method stub
		return prestamoRepository.findAll();
	}

}
