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
import upeu.edu.pe.BibliotecaAPI.Entity.Lector;
import upeu.edu.pe.BibliotecaAPI.Service.LectorService;

@RestController
@RequestMapping("/api/v1/lectores")
public class LectorController {
	@Autowired
	private LectorService lectorService;
	
	@GetMapping
	public ResponseEntity<List<Lector>>readAll(){
		try {
			List<Lector>lectores=lectorService.readAll();
			if (lectores.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(lectores,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<Lector>create(@Valid @RequestBody Lector lec){
		try {
			Lector l=lectorService.create(lec);
			return new ResponseEntity<>(l,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Lector>getLectorId(@PathVariable("id") Long id){
		try {
			Lector l=lectorService.read(id);
			return new ResponseEntity<>(l,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Lector>delLector(@PathVariable("id") Long id){
		try {
			lectorService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Lector>updateLector(@PathVariable("id") Long id, @Valid @RequestBody Lector lec){
		Lector l=lectorService.read(id);
		if (l.getIdLector()>0) {
			return new ResponseEntity<>(lectorService.update(lec),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
