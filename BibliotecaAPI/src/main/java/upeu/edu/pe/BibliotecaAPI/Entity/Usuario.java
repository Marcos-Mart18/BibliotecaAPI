package upeu.edu.pe.BibliotecaAPI.Entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "tbl_usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	@Column(name = "username",columnDefinition = "varchar(20)")
	private String username;
	@Column(name = "password",columnDefinition = "varchar(100)")
	private String password;
	@Column(name = "estado",columnDefinition = "char(1)")
	private char estado;
	
		
	@OneToOne
	@JoinColumn(name = "id_empleado")
	private Empleado empleado;
	
	@OneToMany(mappedBy = "usuario")
	@JsonIgnore
	private List<UsuarioRol>usuarioRoles;
	
	
	
}
