package upeu.edu.pe.BibliotecaAPI.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import upeu.edu.pe.BibliotecaAPI.Dao.LibroDao;
import upeu.edu.pe.BibliotecaAPI.Entity.Libro;
import upeu.edu.pe.BibliotecaAPI.Service.LibroService;
@Service
public class LibroServiceImpl implements LibroService{

	@Autowired
	private LibroDao libroDao;
	@Override
	public Libro create(Libro l) {
		// TODO Auto-generated method stub
		return libroDao.create(l);
	}

	@Override
	public Libro update(Libro l) {
		// TODO Auto-generated method stub
		return libroDao.update(l);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		libroDao.delete(id);
	}

	@Override
	public Libro read(Long id) {
		// TODO Auto-generated method stub
		return libroDao.read(id);
	}

	@Override
	public List<Libro> readAll() {
		// TODO Auto-generated method stub
		return libroDao.readAll();
	}

	@Override
	public Libro registrarLibroAutor(Long idLibro, Long idAutor) {
		// TODO Auto-generated method stub
		return libroDao.registrarLibroAutor(idLibro, idAutor);
	}


}
