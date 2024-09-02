package upeu.edu.pe.BibliotecaAPI.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import upeu.edu.pe.BibliotecaAPI.Entity.Acceso;
@Service
public interface AccesoService {
	Acceso create(Acceso ac);
	Acceso update(Acceso ac);
	void delete(Long id);
	Acceso read(Long id);
	List<Acceso>readAll();
}
