package upeu.edu.pe.BibliotecaAPI.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "tbl_categorias")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Long idCategoria;
	@Column(name = "nombre", columnDefinition = "varchar(50)")
	private String nombre;
	@Column(name = "estado",columnDefinition = "char(1)")
	private char estado;
	
	@OneToMany(targetEntity = Seccion.class, fetch = FetchType.LAZY, mappedBy = "categoria")
	@JsonIgnore
	private List<Seccion> secciones;
}
