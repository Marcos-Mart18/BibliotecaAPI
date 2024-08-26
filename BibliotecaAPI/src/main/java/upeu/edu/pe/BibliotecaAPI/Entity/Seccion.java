package upeu.edu.pe.BibliotecaAPI.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "tbl_secciones")
public class Seccion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSeccion;
	@Column(name = "seccion",columnDefinition = "varchar(20)")
	private String seccion;
	@Column(name = "estado",columnDefinition = "char(1)")
	private char estado;
	
	@ManyToOne(targetEntity = Categoria.class)
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
	@OneToMany(targetEntity = Libro.class, fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "seccion")
	@JsonIgnore
	private List<Libro> libros;
}
