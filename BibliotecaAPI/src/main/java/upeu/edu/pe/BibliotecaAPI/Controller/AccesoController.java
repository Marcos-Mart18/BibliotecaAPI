package upeu.edu.pe.BibliotecaAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import upeu.edu.pe.BibliotecaAPI.Entity.Acceso;
import upeu.edu.pe.BibliotecaAPI.Service.AccesoService;

@RestController
@RequestMapping("/api/v1/accesos")
public class AccesoController {
	@Autowired
	private AccesoService accesoService;
	
	@GetMapping
	public ResponseEntity<List<Acceso>>readAll(){
		try {
			List<Acceso>accesos=accesoService.readAll();
			if (accesos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(accesos,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<Acceso>create(@Valid @RequestBody Acceso acceso){
		try {
			Acceso a=accesoService.create(acceso);
			return new ResponseEntity<>(a,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Acceso>getAccesoId(@PathVariable("id") Long id){
		try {
			Acceso a=accesoService.read(id);
			return new ResponseEntity<>(a,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Acceso>updateAcceso(@PathVariable("id") Long id,@Valid @RequestBody Acceso acce){
		Acceso a=accesoService.read(id);
		if (a.getIdAcceso()>0) {
			return new ResponseEntity<>(accesoService.update(acce),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(a,HttpStatus.NO_CONTENT);
		}
	}
}
