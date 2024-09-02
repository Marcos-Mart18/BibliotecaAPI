package upeu.edu.pe.BibliotecaAPI.Entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_Libro_Autor")
public class LibroAutor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLibroAutor;
	
	
	@ManyToOne
	@JoinColumn(name = "id_libro")
	private Libro libro;
	
	
	@ManyToOne
	@JoinColumn(name = "id_autor")
	private Autor autor;
	
	
}
