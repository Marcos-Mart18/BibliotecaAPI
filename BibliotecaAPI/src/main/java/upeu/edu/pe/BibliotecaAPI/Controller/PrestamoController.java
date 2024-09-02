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
import upeu.edu.pe.BibliotecaAPI.Entity.Prestamo;
import upeu.edu.pe.BibliotecaAPI.Service.PrestamoService;

@RestController
@RequestMapping("/api/v1/prestamos")
public class PrestamoController {
	@Autowired
	private PrestamoService prestamoService;
	
	@GetMapping
	public ResponseEntity<List<Prestamo>>readAll(){
		try {
			List<Prestamo>prestamos=prestamoService.readALL();
			if (prestamos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(prestamos,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<Prestamo>create(@Valid @RequestBody Prestamo pres){
		try {
			Prestamo p=prestamoService.create(pres);
			return new ResponseEntity<>(p,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Prestamo>getPrestamoId(@PathVariable("id") Long id){
		try {
			Prestamo p=prestamoService.read(id);
			return new ResponseEntity<>(p,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Prestamo>delPrestamo(@PathVariable("id") Long id){
		try {
			prestamoService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Prestamo>updatePrestamo(@PathVariable("id") Long id,@Valid @RequestBody Prestamo pres){
		Prestamo p=prestamoService.read(id);
		if (p.getIdPrestamo()>0) {
			return new ResponseEntity<>(prestamoService.update(pres),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
