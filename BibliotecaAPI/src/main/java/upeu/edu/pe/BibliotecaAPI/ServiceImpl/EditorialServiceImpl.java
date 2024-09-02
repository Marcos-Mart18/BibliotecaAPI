package upeu.edu.pe.BibliotecaAPI.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.BibliotecaAPI.Dao.EditorialDao;
import upeu.edu.pe.BibliotecaAPI.Entity.Editorial;
import upeu.edu.pe.BibliotecaAPI.Service.EditorialService;

@Service
public class EditorialServiceImpl implements EditorialService {
	@Autowired
	private EditorialDao editorialDAO;
	@Override
	public Editorial create(Editorial e) {
		// TODO Auto-generated method stub
		return editorialDAO.create(e);
	}

	@Override
	public Editorial update(Editorial e) {
		// TODO Auto-generated method stub
		return editorialDAO.update(e);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		editorialDAO.delete(id);
	}

	@Override
	public Editorial read(Long id) {
		// TODO Auto-generated method stub
		return editorialDAO.read(id);
	}

	@Override
	public List<Editorial> readAll() {
		// TODO Auto-generated method stub
		return editorialDAO.readAll();
	}
	
}
