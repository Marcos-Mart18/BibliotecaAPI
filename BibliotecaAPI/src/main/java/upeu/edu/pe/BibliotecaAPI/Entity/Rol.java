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
@Table(name = "tbl_roles")
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRol;
	@Column(name = "nombre",columnDefinition = "varchar(40)")
	private String nombre;
	@Column(name = "estado",columnDefinition = "char(1)")
	private char estado;
	

		
	@OneToMany(mappedBy = "rol")
	@JsonIgnore
	private List<UsuarioRol>usuarioRoles;	
	
	
	@OneToMany(mappedBy = "rol")
	@JsonIgnore
	private List<AccesoRol>accesoRoles;
		
}
