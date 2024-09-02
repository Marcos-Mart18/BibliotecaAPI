package upeu.edu.pe.BibliotecaAPI.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.BibliotecaAPI.Dao.EditorialDao;
import upeu.edu.pe.BibliotecaAPI.Entity.Editorial;
import upeu.edu.pe.BibliotecaAPI.Repository.EditorialRepository;

@Component
public class EditorialDaoImpl implements EditorialDao{
	@Autowired
	private EditorialRepository editorialRepository;
	@Override
	public Editorial create(Editorial e) {
		// TODO Auto-generated method stub
		return editorialRepository.save(e);
	}

	@Override
	public Editorial update(Editorial e) {
		// TODO Auto-generated method stub
		return editorialRepository.save(e);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		editorialRepository.deleteById(id);
	}

	@Override
	public Editorial read(Long id) {
		// TODO Auto-generated method stub
		return editorialRepository.findById(id).get();
	}

	@Override
	public List<Editorial> readAll() {
		// TODO Auto-generated method stub
		return editorialRepository.findAll();
	}
	
}
