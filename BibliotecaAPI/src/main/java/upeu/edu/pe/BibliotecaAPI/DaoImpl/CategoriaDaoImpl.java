package upeu.edu.pe.BibliotecaAPI.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.BibliotecaAPI.Dao.CategoriaDao;
import upeu.edu.pe.BibliotecaAPI.Entity.Categoria;
import upeu.edu.pe.BibliotecaAPI.Repository.CategoriaRepository;
@Component
public class CategoriaDaoImpl implements CategoriaDao{
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Override
	public Categoria create(Categoria c) {
		// TODO Auto-generated method stub
		return categoriaRepository.save(c);
	}

	@Override
	public Categoria update(Categoria c) {
		// TODO Auto-generated method stub
		return categoriaRepository.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		categoriaRepository.deleteById(id);
	}

	@Override
	public Categoria read(Long id) {
		// TODO Auto-generated method stub
		return categoriaRepository.findById(id).get();
	}

	@Override
	public List<Categoria> readAll() {
		// TODO Auto-generated method stub
		return categoriaRepository.findAll();
	}

}
