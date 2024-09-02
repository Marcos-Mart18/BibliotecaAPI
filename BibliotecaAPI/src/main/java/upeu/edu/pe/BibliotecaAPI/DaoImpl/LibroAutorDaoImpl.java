package upeu.edu.pe.BibliotecaAPI.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.BibliotecaAPI.Dao.LibroAutorDao;
import upeu.edu.pe.BibliotecaAPI.Entity.LibroAutor;
import upeu.edu.pe.BibliotecaAPI.Repository.LibroAutorRepository;

@Component
public class LibroAutorDaoImpl implements LibroAutorDao  {
	@Autowired
	private LibroAutorRepository libroAutorRepository;
	@Override
	public LibroAutor create(LibroAutor lb) {
		// TODO Auto-generated method stub
		return libroAutorRepository.save(lb);
	}

	@Override
	public LibroAutor update(LibroAutor lb) {
		// TODO Auto-generated method stub
		return libroAutorRepository.save(lb);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		libroAutorRepository.deleteById(id);
	}

	@Override
	public LibroAutor read(Long id) {
		// TODO Auto-generated method stub
		return libroAutorRepository.findById(id).get();
	}

	@Override
	public List<LibroAutor> readAll() {
		// TODO Auto-generated method stub
		return libroAutorRepository.findAll();
	}

}
