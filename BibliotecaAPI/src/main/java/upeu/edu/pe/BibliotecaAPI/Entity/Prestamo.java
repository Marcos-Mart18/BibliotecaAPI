package upeu.edu.pe.BibliotecaAPI.Entity;


import jakarta.persistence.Column;
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
@Table(name = "tbl_prestamos")
public class Prestamo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPrestamo;
	@Column(name = "fecha_prestamo",columnDefinition = "DATE")
	private String fechaPrestamo;
	@Column(name = "fecha_entrega",columnDefinition = "DATE")
	private String fechaEntrega;
	@Column(name = "estado",columnDefinition = "char(1)")
	private char estado;
	
	
	
	
	@ManyToOne
	@JoinColumn(name = "id_lector")
	private Lector lector;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
}
