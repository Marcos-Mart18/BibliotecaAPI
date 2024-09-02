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
import upeu.edu.pe.BibliotecaAPI.Entity.DetallePrestamo;
import upeu.edu.pe.BibliotecaAPI.Service.DetallePrestamoService;

@RestController
@RequestMapping("/api/v1/detallesprestamos")
public class DetallePrestamoController {
	@Autowired
	private  DetallePrestamoService detallePrestamoService;
	
	@GetMapping
	public ResponseEntity<List<DetallePrestamo>>readAll(){
		try {
			List<DetallePrestamo>detalles=detallePrestamoService.readAll();
			if (detalles.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(detalles,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<DetallePrestamo>create(@Valid @RequestBody DetallePrestamo det){
		try {
			DetallePrestamo d=detallePrestamoService.create(det);
			return new ResponseEntity<>(d,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetallePrestamo>getDetalleId(@PathVariable("id") Long id){
		try {
			DetallePrestamo de=detallePrestamoService.read(id);
			return new ResponseEntity<>(de,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<DetallePrestamo>delDetalle(@PathVariable("id") Long id){
		try {
			detallePrestamoService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DetallePrestamo>updateDetalle(@PathVariable("id") Long id,@Valid @RequestBody DetallePrestamo det){
		DetallePrestamo d=detallePrestamoService.read(id);
		if (d.getIdDetaPresta()>0) {
			return new ResponseEntity<>(detallePrestamoService.update(det),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
