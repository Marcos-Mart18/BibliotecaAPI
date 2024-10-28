package upeu.edu.pe.BibliotecaAPI.Entity;



import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	private Long idLibro;
	@Column(name = "titulo", columnDefinition = "varchar(50)")
	private String titulo;
	@Column(name = "paginas", columnDefinition = "INTEGER")
	private Long paginas;
	@Column(name = "edicion", columnDefinition = "varchar(20)")
	private String edicion;
	@Column(name = "portada", columnDefinition = "char(1)")
	private char portada;
	@Column(name = "descripcion", columnDefinition = "varchar(50)")
	private String descripcion;
	@Column(name = "estado",columnDefinition = "char(1)")
	private char estado;
	
	@ManyToOne
	@JoinColumn(name = "id_seccion")
	private Seccion seccion;
	
	
	@ManyToOne
	@JoinColumn(name = "id_editorial")
	private Editorial editorial;
	
	
	@ManyToMany
	@JoinTable(
			name = "libro_autor",
			joinColumns = @JoinColumn(name="libro_id",referencedColumnName = "idLibro"),
			inverseJoinColumns = @JoinColumn(name="autor_id",referencedColumnName = "idAutor")
			)
	@JsonIgnore
	private Set<Autor>autores=new HashSet<>();
}
