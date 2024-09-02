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
@Table(name = "tbl_detalle_prestamos")
public class DetallePrestamo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDetaPresta;
	@Column(name = "observaciones",columnDefinition = "varchar(50)")
	private String observaciones;
	@Column(name = "fecha_entrega",columnDefinition = "DATE")
	private String fechaEntrega;
	@Column(name = "estado",columnDefinition = "char(1)")
	private char estado;
	
	@ManyToOne
	@JoinColumn(name = "id_libro")
	private Libro libro;
	
	@ManyToOne
	@JoinColumn(name = "id_prestamo")
	private Prestamo prestamo;
}
