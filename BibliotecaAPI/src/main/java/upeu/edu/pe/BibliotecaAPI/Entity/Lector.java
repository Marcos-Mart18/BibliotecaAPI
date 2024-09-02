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
@Table(name = "tbl_lectores")
public class Lector {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLector;
	@Column(name = "nombres",columnDefinition = "varchar(50)")
	private String nombres;
	@Column(name = "apellidos",columnDefinition = "varchar(50)")
	private String apellidos;
	@Column(name = "documentos",columnDefinition = "char(2)")
	private char documento;
	@Column(name = "telefono",columnDefinition = "varchar(15)")
	private String telefono;
	@Column(name = "direccion",columnDefinition = "varchar(50)")
	private String direccion;
	@Column(name = "estado",columnDefinition = "char(1)")
	private char estado;
	

	
}
