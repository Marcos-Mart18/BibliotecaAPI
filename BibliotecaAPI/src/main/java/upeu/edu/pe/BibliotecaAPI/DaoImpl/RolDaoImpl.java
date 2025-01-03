package upeu.edu.pe.BibliotecaAPI.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.BibliotecaAPI.Dao.RolDao;
import upeu.edu.pe.BibliotecaAPI.Entity.Acceso;
import upeu.edu.pe.BibliotecaAPI.Entity.Rol;
import upeu.edu.pe.BibliotecaAPI.Repository.AccesoRepository;
import upeu.edu.pe.BibliotecaAPI.Repository.RolRepository;

@Component
public class RolDaoImpl implements RolDao{
	@Autowired
	private RolRepository rolRepository;
	
	@Autowired
	private AccesoRepository accesoRepository;
	@Override
	public Rol create(Rol r) {
		// TODO Auto-generated method stub
		return rolRepository.save(r);
	}

	@Override
	public Rol update(Rol r) {
		// TODO Auto-generated method stub
		return rolRepository.save(r);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		rolRepository.deleteById(id);
	}

	@Override
	public Rol read(Long id) {
		// TODO Auto-generated method stub
		return rolRepository.findById(id).get();
	}

	@Override
	public List<Rol> readAll() {
		// TODO Auto-generated method stub
		return rolRepository.findAll();
	}

	@Override
	public Rol registrarAccesoRol(Long idRol, Long idAcceso) {
		// TODO Auto-generated method stub
		Rol rol = rolRepository.findById(idRol).orElseThrow(() -> new RuntimeException("Rol no encontrado con ID: " + idRol));
	    Acceso ac = accesoRepository.findById(idAcceso).orElseThrow(() -> new RuntimeException("Acceso no encontrado con ID: " + idAcceso));
		
		rol.getAccesos().add(ac);
		ac.getRoles().add(rol);
		
		return rolRepository.save(rol);
	}

}
