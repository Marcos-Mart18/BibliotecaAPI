package upeu.edu.pe.BibliotecaAPI.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import upeu.edu.pe.BibliotecaAPI.Dao.AccesoRolDao;
import upeu.edu.pe.BibliotecaAPI.Entity.AccesoRol;
import upeu.edu.pe.BibliotecaAPI.Repository.AccesoRolRepository;
@Component
public class AccesoRolDaoImpl implements AccesoRolDao{
	@Autowired
	private AccesoRolRepository accesoRolRepository;
	@Override
	public AccesoRol create(AccesoRol ar) {
		// TODO Auto-generated method stub
		return accesoRolRepository.save(ar);
	}

	@Override
	public AccesoRol update(AccesoRol ar) {
		// TODO Auto-generated method stub
		return accesoRolRepository.save(ar);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		accesoRolRepository.deleteById(id);
	}

	@Override
	public AccesoRol read(Long id) {
		// TODO Auto-generated method stub
		return accesoRolRepository.findById(id).get();
	}

	@Override
	public List<AccesoRol> readAll() {
		// TODO Auto-generated method stub
		return accesoRolRepository.findAll();
	}

}
