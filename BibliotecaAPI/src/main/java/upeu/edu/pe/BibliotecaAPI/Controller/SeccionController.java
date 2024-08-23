package upeu.edu.pe.BibliotecaAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import upeu.edu.pe.BibliotecaAPI.Entity.Seccion;
import upeu.edu.pe.BibliotecaAPI.Service.SeccionService;

@RestController
@RequestMapping("api/v1/secciones")
public class SeccionController {

	@Autowired
	private SeccionService seccionService;
	
	@GetMapping
	public ResponseEntity<List<Seccion>> readAll(){
		try {
			List<Seccion> secciones = seccionService.readAll();
			if (secciones.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(secciones,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<Seccion> create(@Valid @RequestBody Seccion sec){
		try {
			Seccion s=seccionService.create(sec);
			return new ResponseEntity<>(s,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Seccion> getSeccionId(@PathVariable("id") Long id){
		try {
			Seccion c=seccionService.read(id);
			return new ResponseEntity<>(c,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping
	public ResponseEntity<Seccion> delSeccion(@PathVariable("id") Long id){
		try {
			seccionService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	public ResponseEntity<Seccion> updateSeccion(@PathVariable("id") Long id,@Valid @RequestBody Seccion sec){
		Seccion s=seccionService.read(id);
		if (s.getIdSeccion()>0) {
			return new ResponseEntity<>(seccionService.update(s),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
