package upeu.edu.pe.BibliotecaAPI.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.BibliotecaAPI.Dao.LibroDao;
import upeu.edu.pe.BibliotecaAPI.Entity.Libro;
import upeu.edu.pe.BibliotecaAPI.Repository.LibroRepository;
@Component
public class LibroDaoImpl implements LibroDao {
	@Autowired
	private LibroRepository libroRepository;
	@Override
	public Libro create(Libro l) {
		// TODO Auto-generated method stub
		return libroRepository.save(l);
	}

	@Override
	public Libro update(Libro l) {
		// TODO Auto-generated method stub
		return libroRepository.save(l);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		libroRepository.deleteById(id);
	}

	@Override
	public Libro read(Long id) {
		// TODO Auto-generated method stub
		return libroRepository.findById(id).get();
	}

	@Override
	public List<Libro> readAll() {
		// TODO Auto-generated method stub
		return libroRepository.findAll();
	}

}
