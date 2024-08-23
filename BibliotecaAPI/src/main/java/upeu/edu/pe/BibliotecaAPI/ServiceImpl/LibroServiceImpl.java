package upeu.edu.pe.BibliotecaAPI.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.BibliotecaAPI.Dao.CategoriaDao;
import upeu.edu.pe.BibliotecaAPI.Entity.Categoria;
import upeu.edu.pe.BibliotecaAPI.Service.CategoriaService;
@Service
public class LibroServiceImpl implements CategoriaService{
	@Autowired
	private CategoriaDao categoriaDao;
	@Override
	public Categoria create(Categoria c) {
		// TODO Auto-generated method stub
		return categoriaDao.create(c);
	}

	@Override
	public Categoria update(Categoria c) {
		// TODO Auto-generated method stub
		return categoriaDao.update(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		categoriaDao.delete(id);
	}

	@Override
	public Categoria read(Long id) {
		// TODO Auto-generated method stub
		return categoriaDao.read(id);
	}

	@Override
	public List<Categoria> readAll() {
		// TODO Auto-generated method stub
		return categoriaDao.readAll();
	}

}
