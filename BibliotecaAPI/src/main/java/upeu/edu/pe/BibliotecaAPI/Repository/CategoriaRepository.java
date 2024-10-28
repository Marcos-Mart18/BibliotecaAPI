package upeu.edu.pe.BibliotecaAPI.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import upeu.edu.pe.BibliotecaAPI.Entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	@Query(
		    value = "SELECT * FROM tbl_categorias WHERE tbl_categorias.nombre LIKE CONCAT('%', :filtro, '%')",
		    nativeQuery = true
		)
		List<Categoria> searchNative(@Param("filtro") String filtro);
	
}
