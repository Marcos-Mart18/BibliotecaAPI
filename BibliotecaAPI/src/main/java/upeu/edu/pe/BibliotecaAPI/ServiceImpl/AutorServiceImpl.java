package upeu.edu.pe.BibliotecaAPI.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.BibliotecaAPI.Dao.AutorDao;
import upeu.edu.pe.BibliotecaAPI.Entity.Autor;
import upeu.edu.pe.BibliotecaAPI.Service.AutorService;

@Service
public class AutorServiceImpl implements AutorService {
	
	@Autowired
	private AutorDao autorDAO;
	@Override
	public Autor create(Autor a) {
		// TODO Auto-generated method stub
		return autorDAO.create(a);
	}

	@Override
	public Autor update(Autor a) {
		// TODO Auto-generated method stub
		return autorDAO.update(a);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		 autorDAO.delete(id);
	}

	@Override
	public Autor read(Long id) {
		// TODO Auto-generated method stub
		return autorDAO.read(id);
	}

	@Override
	public List<Autor> readAll() {
		// TODO Auto-generated method stub
		return autorDAO.readAll();
	}
	
}
