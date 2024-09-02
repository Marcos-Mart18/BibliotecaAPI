package upeu.edu.pe.BibliotecaAPI.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import upeu.edu.pe.BibliotecaAPI.Entity.Empleado;
@Service
public interface EmpleadoService {
	Empleado create(Empleado em);
	Empleado update(Empleado em);
	void delete(Long id);
	Empleado read(Long id);
	List<Empleado>readAll();
}
