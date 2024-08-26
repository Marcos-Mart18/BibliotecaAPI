package upeu.edu.pe.BibliotecaAPI.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tbl_libros")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_libro")
	private Long idlibro;
	@Column(name = "titulo", columnDefinition = "varchar(50)")
	private String titulo;
	@Column(name = "paginas", columnDefinition = "INTEGER")
	private Long paginas;
	@Column(name = "edicion", columnDefinition = "varchar(20)")
	private String edicion;
	@Column(name = "estado",columnDefinition = "char(1)")
	private char estado;
	
	@ManyToOne(targetEntity = Seccion.class)
	@JoinColumn(name = "id_seccion")
	private Seccion seccion;
	
	
	@ManyToMany(targetEntity = Autor.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "libro_autor",joinColumns = @JoinColumn(name = "id_libro"),inverseJoinColumns = @JoinColumn(name = "id_autor"))
	private List<Autor>autores;

}
