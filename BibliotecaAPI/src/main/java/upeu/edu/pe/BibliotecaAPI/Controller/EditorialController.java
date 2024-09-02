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
import upeu.edu.pe.BibliotecaAPI.Entity.Editorial;
import upeu.edu.pe.BibliotecaAPI.Service.EditorialService;

@RestController
@RequestMapping("/api/v1/editoriales")
public class EditorialController {
	@Autowired
	private EditorialService editorialService;
	
	@GetMapping
	public ResponseEntity<List<Editorial>>readAll(){
		try {
			List<Editorial>editoriales=editorialService.readAll();
			if (editoriales.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(editoriales,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<Editorial>create(@Valid @RequestBody Editorial edi){
		try {
			Editorial e=editorialService.create(edi);
			return new ResponseEntity<>(e,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Editorial>getEditorialId(@PathVariable("id") Long id){
		try {
			Editorial e=editorialService.read(id);
			return new ResponseEntity<>(e,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Editorial>delEditorial(@PathVariable("id") Long id){
		try {
			editorialService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Editorial>update(@PathVariable("id") Long id,@Valid @RequestBody Editorial edi){
		Editorial e=editorialService.read(id);
		if (e.getIdEditorial()>0) {
			return new ResponseEntity<>(editorialService.update(edi),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
