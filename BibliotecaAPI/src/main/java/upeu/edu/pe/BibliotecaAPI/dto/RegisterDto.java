package upeu.edu.pe.BibliotecaAPI.dto;

import lombok.Data;

@Data
public class RegisterDto {
	private String username;
	private String password;
	private String roleName;
	private Long idEmpleado;
}
