package upeu.edu.pe.BibliotecaAPI.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import upeu.edu.pe.BibliotecaAPI.Entity.AccesoRol;

@Component
public interface AccesoRolDao {
	AccesoRol create(AccesoRol ar);
	AccesoRol update(AccesoRol ar);
	void delete(Long id);
	AccesoRol read(Long id);
	List<AccesoRol>readAll();
}
