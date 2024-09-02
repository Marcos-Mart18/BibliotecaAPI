package upeu.edu.pe.BibliotecaAPI.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.BibliotecaAPI.Dao.AccesoDao;
import upeu.edu.pe.BibliotecaAPI.Entity.Acceso;
import upeu.edu.pe.BibliotecaAPI.Repository.AccesoRepository;

@Component
public class AccesoDaoImpl implements AccesoDao{
	@Autowired
	private AccesoRepository accesoRepository;
	@Override
	public Acceso create(Acceso ac) {
		// TODO Auto-generated method stub
		return accesoRepository.save(ac);
	}

	@Override
	public Acceso update(Acceso ac) {
		// TODO Auto-generated method stub
		return accesoRepository.save(ac);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		accesoRepository.deleteById(id);
	}

	@Override
	public Acceso read(Long id) {
		// TODO Auto-generated method stub
		return accesoRepository.findById(id).get();
	}

	@Override
	public List<Acceso> readAll() {
		// TODO Auto-generated method stub
		return accesoRepository.findAll();
	}

}
