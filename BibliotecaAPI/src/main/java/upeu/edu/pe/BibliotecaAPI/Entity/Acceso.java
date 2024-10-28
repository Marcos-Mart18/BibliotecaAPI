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
@Table(name = "tbl_accesos")
public class Acceso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAcceso;
	@Column(name = "titulo",columnDefinition = "varchar(40)")
	private String titulo;
	@Column(name = "icono",columnDefinition = "varchar(40)")
	private String icono;
	@Column(name = "url",columnDefinition = "varchar(100)")
	private String url;
	@Column(name = "estado",columnDefinition = "char(1)")
	private char estado;
	
	@ManyToMany(mappedBy = "accesos", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonBackReference
	private Set<Rol> roles= new HashSet<>();
}
