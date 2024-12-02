package upeu.edu.pe.BibliotecaAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import upeu.edu.pe.BibliotecaAPI.Entity.Categoria;
import upeu.edu.pe.BibliotecaAPI.Service.CategoriaService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/categorias")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoriaController {
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping	
	public ResponseEntity<List<Categoria>> readAll(){
		try {
			List<Categoria> categorias = categoriaService.readAll();
			if (categorias.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(categorias,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<Categoria> crear(@Valid @RequestBody Categoria cat){
		try {
			Categoria c= categoriaService.create(cat);
			return new ResponseEntity<>(c,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getCategoriaId(@PathVariable("id") Long id){
		try {
			Categoria c=categoriaService.read(id);
			return new ResponseEntity<>(c,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Categoria> delCategoria(@PathVariable("id") Long id){
		try {
			categoriaService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Categoria> updateCategoria(@PathVariable("id") Long id, @Valid @RequestBody Categoria cat) {
	    try {
	        // Leer la categoría por ID
	        Categoria c = categoriaService.read(id);

	        // Validar si la categoría existe
	        if (c == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna 404 si no se encuentra
	        }

	        // Actualizar la categoría
	        cat.setIdCategoria(id); // Asegurarse de que el ID esté configurado
	        Categoria categoriaActualizada = categoriaService.update(cat);
	        return new ResponseEntity<>(categoriaActualizada, HttpStatus.OK);
	    } catch (Exception e) {
	        // Manejo genérico de excepciones
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	
	@GetMapping("/search")
    public ResponseEntity<List<Categoria>> buscarCategoria(@RequestParam String filtro) {
        try {
            List<Categoria> categorias = categoriaService.searchCategoria(filtro);
            return ResponseEntity.ok(categorias);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
