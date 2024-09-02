package upeu.edu.pe.BibliotecaAPI.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.BibliotecaAPI.Dao.EmpleadoDao;
import upeu.edu.pe.BibliotecaAPI.Entity.Empleado;
import upeu.edu.pe.BibliotecaAPI.Service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	@Autowired
	private EmpleadoDao empleadoDao;
	@Override
	public Empleado create(Empleado em) {
		// TODO Auto-generated method stub
		return empleadoDao.create(em);
	}

	@Override
	public Empleado update(Empleado em) {
		// TODO Auto-generated method stub
		return empleadoDao.update(em);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		empleadoDao.delete(id);
	}

	@Override
	public Empleado read(Long id) {
		// TODO Auto-generated method stub
		return empleadoDao.read(id);
	}

	@Override
	public List<Empleado> readAll() {
		// TODO Auto-generated method stub
		return empleadoDao.readAll();
	}

}
