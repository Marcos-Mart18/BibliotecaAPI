package upeu.edu.pe.BibliotecaAPI.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	@Column(name = "id_autor")
	private Long idAutor;
	@Column(name = "nombres", columnDefinition = "varchar(50)")
	private String nombres;
	@Column(name = "apellidos",columnDefinition = "varchar(50)")
	private String apellidos;
	@Column(name = "pais",columnDefinition = "char(18)")
	private String pais;
	@Column(name = "estado",columnDefinition = "char(1)")
	private char estado;
	

}
