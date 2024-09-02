package upeu.edu.pe.BibliotecaAPI.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.BibliotecaAPI.Dao.AutorDao;
import upeu.edu.pe.BibliotecaAPI.Entity.Autor;
import upeu.edu.pe.BibliotecaAPI.Repository.AutorRepository;

@Component
public class AutorDaoImpl implements AutorDao {
	@Autowired
	private AutorRepository autorRepository;
	@Override
	public Autor create(Autor a) {
		// TODO Auto-generated method stub
		return autorRepository.save(a);
	}

	@Override
	public Autor update(Autor a) {
		// TODO Auto-generated method stub
		return autorRepository.save(a);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		autorRepository.deleteById(id);
	}

	@Override
	public Autor read(Long id) {
		// TODO Auto-generated method stub
		return autorRepository.findById(id).get();
	}

	@Override
	public List<Autor> readAll() {
		// TODO Auto-generated method stub
		return autorRepository.findAll();
	}

}
