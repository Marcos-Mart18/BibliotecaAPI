package upeu.edu.pe.BibliotecaAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import upeu.edu.pe.BibliotecaAPI.Entity.AccesoRol;
import upeu.edu.pe.BibliotecaAPI.Service.AccesoRolService;

@RestController
@RequestMapping("/api/v1/acceso_rol")
public class AccesoRolController {
	@Autowired
	private AccesoRolService accesoRolService;
	
	@GetMapping
	public ResponseEntity<List<AccesoRol>>readAll(){
		try {
			List<AccesoRol>accesoRoles=accesoRolService.readAll();
			if (accesoRoles.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(accesoRoles,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<AccesoRol>create(@Valid @RequestBody AccesoRol acro){
		try {
			AccesoRol ar=accesoRolService.create(acro);
			return new ResponseEntity<>(ar,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AccesoRol>getAccesoRolId(@PathVariable("id") Long id){
		try {
			AccesoRol ar=accesoRolService.read(id);
			return new ResponseEntity<>(ar,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<AccesoRol>delAccesoRol(@PathVariable("id") Long id){
		try {
			accesoRolService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AccesoRol>updateAccesoRol(@PathVariable("id") Long id,@Valid @RequestBody AccesoRol acro){
		AccesoRol ar=accesoRolService.read(id);
		if (ar.getIdAccesoRoL()>0) {
			return new ResponseEntity<>(accesoRolService.update(acro),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
