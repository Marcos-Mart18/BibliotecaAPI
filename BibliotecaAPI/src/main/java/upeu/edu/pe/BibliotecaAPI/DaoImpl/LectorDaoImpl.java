package upeu.edu.pe.BibliotecaAPI.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.BibliotecaAPI.Dao.LectorDao;
import upeu.edu.pe.BibliotecaAPI.Entity.Lector;
import upeu.edu.pe.BibliotecaAPI.Repository.LectorRepository;
@Component
public class LectorDaoImpl implements LectorDao{
	@Autowired
	private LectorRepository lectorRepository;
	
	@Override
	public Lector create(Lector le) {
		// TODO Auto-generated method stub
		return lectorRepository.save(le);
	}

	@Override
	public Lector update(Lector le) {
		// TODO Auto-generated method stub
		return lectorRepository.save(le);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		lectorRepository.deleteById(id);
	}

	@Override
	public Lector read(Long id) {
		// TODO Auto-generated method stub
		return lectorRepository.findById(id).get();
	}

	@Override
	public List<Lector> readAll() {
		// TODO Auto-generated method stub
		return lectorRepository.findAll();
	}

}
