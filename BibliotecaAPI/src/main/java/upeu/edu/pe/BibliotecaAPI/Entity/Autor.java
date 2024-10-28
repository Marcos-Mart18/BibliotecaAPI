			package upeu.edu.pe.BibliotecaAPI.Entity;




import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
@Table(name = "tbl_autores")
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAutor;
	@Column(name = "nombres", columnDefinition = "varchar(50)")
	private String nombres;
	@Column(name = "apellidos",columnDefinition = "varchar(50)")
	private String apellidos;
	@Column(name = "pais",columnDefinition = "char(18)")
	private String pais;
	@Column(name = "estado",columnDefinition = "char(1)")
	private char estado;
	
	@ManyToMany(mappedBy = "autores",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonBackReference
	private Set<Libro>libros=new HashSet<>();

	
}
