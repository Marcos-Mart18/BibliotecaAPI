package upeu.edu.pe.BibliotecaAPI.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.BibliotecaAPI.Dao.LibroAutorDao;
import upeu.edu.pe.BibliotecaAPI.Entity.LibroAutor;
import upeu.edu.pe.BibliotecaAPI.Service.LibroAutorService;

@Service
public class LibroAutorServiceImpl implements LibroAutorService {
	@Autowired
	private LibroAutorDao libroAutorDao;
	@Override
	public LibroAutor create(LibroAutor lb) {
		// TODO Auto-generated method stub
		return libroAutorDao.create(lb);
	}

	@Override
	public LibroAutor update(LibroAutor lb) {
		// TODO Auto-generated method stub
		return libroAutorDao.update(lb);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		libroAutorDao.delete(id);
	}

	@Override
	public LibroAutor read(Long id) {
		// TODO Auto-generated method stub
		return libroAutorDao.read(id);
	}

	@Override
	public List<LibroAutor> readAll() {
		// TODO Auto-generated method stub
		return libroAutorDao.readAll();
	}
	
}
