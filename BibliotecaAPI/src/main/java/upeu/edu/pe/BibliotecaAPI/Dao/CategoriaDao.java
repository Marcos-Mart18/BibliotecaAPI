package upeu.edu.pe.BibliotecaAPI.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import upeu.edu.pe.BibliotecaAPI.Entity.Categoria;
@Component
public interface CategoriaDao {
	Categoria create(Categoria c);
	Categoria update(Categoria c);
	void delete(Long id);
	Categoria read(Long id);
	List<Categoria>readAll();
	List<Categoria>searchCategoria(String filtro);
}
