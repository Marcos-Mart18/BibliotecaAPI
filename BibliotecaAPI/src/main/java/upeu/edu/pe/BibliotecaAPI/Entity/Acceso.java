package upeu.edu.pe.BibliotecaAPI.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Setter
@Getter
@Entity
@Table(name = "tbl_accesos")
public class Acceso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAcceso;
	@Column(name = "titulo",columnDefinition = "varchar(40)")
	private String titulo;
	@Column(name = "icono",columnDefinition = "varchar(40)")
	private String icono;
	@Column(name = "url",columnDefinition = "varchar(40)")
	private String url;
	@Column(name = "estado",columnDefinition = "char(1)")
	private char estado;
	
	
	@OneToMany(mappedBy = "acceso")
	@JsonIgnore
	private List<AccesoRol>accesoRoles;
}
