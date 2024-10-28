package upeu.edu.pe.BibliotecaAPI.Entity;




import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
			name = "usuario_rol",
			joinColumns = @JoinColumn(name="usuario_id",referencedColumnName = "idUsuario"),
			inverseJoinColumns = @JoinColumn(name="rol_id",referencedColumnName = "idRol")
			)
	@JsonIgnore
	private Set<Rol>roles = new HashSet<>();
	
	
}
