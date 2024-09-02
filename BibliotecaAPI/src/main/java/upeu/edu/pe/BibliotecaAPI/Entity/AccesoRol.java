package upeu.edu.pe.BibliotecaAPI.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "tbl_acceso_rol")
public class AccesoRol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAccesoRoL; 
	
	@ManyToOne
	@JoinColumn(name = "id_rol")
	private Rol rol;
	
	
	@ManyToOne
	@JoinColumn(name = "id_acceso")
	private Acceso acceso;
}
