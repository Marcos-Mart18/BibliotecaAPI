package upeu.edu.pe.BibliotecaAPI.Service;

import java.util.List;


import org.springframework.stereotype.Service;

import upeu.edu.pe.BibliotecaAPI.Entity.Categoria;
@Service
public interface CategoriaService {
	Categoria create(Categoria c);
	Categoria update(Categoria c);
	void delete(Long id);
	Categoria read(Long id);
	List<Categoria>readAll();
	List<Categoria>searchCategoria(String filtro);
}
