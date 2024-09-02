package upeu.edu.pe.BibliotecaAPI.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import upeu.edu.pe.BibliotecaAPI.Entity.AccesoRol;

@Service
public interface AccesoRolService {
	AccesoRol create(AccesoRol ar);
	AccesoRol update(AccesoRol ar);
	void delete(Long id);
	AccesoRol read(Long id);
	List<AccesoRol>readAll();
}
