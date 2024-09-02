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
import upeu.edu.pe.BibliotecaAPI.Entity.LibroAutor;
import upeu.edu.pe.BibliotecaAPI.Service.LibroAutorService;

@RestController
@RequestMapping("/api/v1/libro_autores")
public class LibroAutorController {
	@Autowired
	private LibroAutorService libroAutorService;
	
	@GetMapping
	public ResponseEntity<List<LibroAutor>>readAll(){
		try {
			List<LibroAutor>libroAutores = libroAutorService.readAll();
			if (libroAutores.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(libroAutores,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<LibroAutor>create(@Valid @RequestBody LibroAutor liba){
		try {
			LibroAutor la = libroAutorService.create(liba);
			return new ResponseEntity<>(la,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LibroAutor>getLibroAutorId(@PathVariable("id") Long id){
		try {
			LibroAutor la= libroAutorService.read(id);
			return new ResponseEntity<>(la,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<LibroAutor>delLibroAutor(@PathVariable("id") Long id){
		try {
			libroAutorService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<LibroAutor>updateLibroAutor(@PathVariable("id") Long id, @Valid @RequestBody LibroAutor liba){
		LibroAutor la=libroAutorService.read(id);
		if (la.getIdLibroAutor()>0) {
			return new ResponseEntity<>(libroAutorService.update(liba),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
