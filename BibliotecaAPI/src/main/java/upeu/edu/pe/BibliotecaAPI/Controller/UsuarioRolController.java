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
import upeu.edu.pe.BibliotecaAPI.Entity.UsuarioRol;
import upeu.edu.pe.BibliotecaAPI.Service.UsuarioRolService;

@RestController
@RequestMapping("/api/v1/usuario_rol")
public class UsuarioRolController {
	@Autowired
	private UsuarioRolService usuarioRolService;
	
	@GetMapping
	public ResponseEntity<List<UsuarioRol>>readAll(){
		try {
			List<UsuarioRol>usuarioRoles=usuarioRolService.readAll();
			if (usuarioRoles.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(usuarioRoles,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<UsuarioRol>create(@Valid @RequestBody UsuarioRol usro){
		try {
			UsuarioRol ur=usuarioRolService.create(usro);
			return new ResponseEntity<>(ur,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioRol>getUsuarioRolId(@PathVariable("id") Long id){
		try {
			UsuarioRol ur=usuarioRolService.read(id);
			return new ResponseEntity<>(ur,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<UsuarioRol>delUsuarioRol(@PathVariable("id") Long id){
		try {
			usuarioRolService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioRol>updateUsuarioRol(@PathVariable("id") Long id,@Valid @RequestBody UsuarioRol usro){
		UsuarioRol ur=usuarioRolService.read(id);
		if (ur.getIdUsuarioRol()>0) {
			return new ResponseEntity<>(usuarioRolService.update(usro),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
