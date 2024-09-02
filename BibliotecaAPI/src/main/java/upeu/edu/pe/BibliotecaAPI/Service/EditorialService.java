package upeu.edu.pe.BibliotecaAPI.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import upeu.edu.pe.BibliotecaAPI.Entity.Editorial;

@Service
public interface EditorialService {
	Editorial create(Editorial e);
	Editorial update(Editorial e);
	void delete(Long id);
	Editorial read(Long id);
	List<Editorial>readAll();
}
