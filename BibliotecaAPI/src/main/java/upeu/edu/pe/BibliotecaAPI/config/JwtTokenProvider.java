	package upeu.edu.pe.BibliotecaAPI.config;
	
	import io.jsonwebtoken.Jwts;
	import io.jsonwebtoken.SignatureAlgorithm;
	import io.jsonwebtoken.io.Decoders;
	import io.jsonwebtoken.security.Keys;
	import upeu.edu.pe.BibliotecaAPI.Entity.Usuario;
	import upeu.edu.pe.BibliotecaAPI.Repository.UsuarioRepository;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.security.core.Authentication;
	import org.springframework.stereotype.Component;
	
	import javax.crypto.SecretKey;
	import java.security.Key;
	import java.util.Date;
import java.util.stream.Collectors;
	
	@Component
	public class JwtTokenProvider {
		
		@Autowired
	    private UsuarioRepository usuarioRepository;

	    private String jwtSecret = "af60addca9ea3e3c099551e1b6576c9966dce0a33de879dd7e160f86dbd872ca236d6e9ee66fb6e30039fe7c345324a10f3d0741b0600fa7a45df4c6691eff4f4209767ed39f51e37717d8feecd5dd14fc34ebe619e6a29ae91d9ffe134cb5718bec0b3680d6ae7fc09e67763fe7c05d05d3ba69f47211163852633755b7f861132d0c98f8d7c1af9152d547408e676867a0a32fb525a4354180f5fb6b2dc23b5faa4155b8db63385f96259a90b6ee0e74a5b90a4f0f4fa96fafc296c64588b5c009b3829ae2e1d69a1cf7569b50a65fa553350495d18816f785f961c970c0a9cb9c8da25cc5e9fa4a3e9527a132d616b232d1ee21c3bf6dc8d9e3376e2e82c0";
	    private long jwtExpirationDate = 15 * 60 * 1000; // 15 minutos en milisegundos
	    private long refreshExpirationDate = 7 * 24 * 60 * 60 * 1000; // 7 días en milisegundos

	    // Generar Access Token
	    public String generateToken(Authentication authentication) {
	        String username = authentication.getName(); // Nombre del usuario autenticado
	        Date currentDate = new Date();
	        Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate);

	        // Obtener todos los roles del usuario autenticado
	        String roles = authentication.getAuthorities().stream()
	                .map(authority -> authority.getAuthority())
	                .collect(Collectors.joining(","));

	        // Construir el token con los campos personalizados
	        return Jwts.builder()
	                .setSubject(username) // Asigna el username como subject
	                .claim("roles", roles) // Agrega el rol al payload
	                .setIssuedAt(currentDate) // Fecha de creación del token
	                .setExpiration(expireDate) // Fecha de expiración
	                .signWith(key(), SignatureAlgorithm.HS256) // Firma con la clave
	                .compact(); // Genera el token
	    }

	    // Generar Refresh Token
	    public String generateRefreshToken(String username) {
	        Date currentDate = new Date();
	        Date expireDate = new Date(currentDate.getTime() + refreshExpirationDate);

	        // Construir el Refresh Token
	        return Jwts.builder()
	                .setSubject(username) // Asigna el username como subject
	                .setIssuedAt(currentDate) // Fecha de creación del token
	                .setExpiration(expireDate) // Fecha de expiración
	                .signWith(key(), SignatureAlgorithm.HS256) // Firma con la clave
	                .compact(); // Genera el token
	    }

	    // Renovar Access Token utilizando el Refresh Token
	    public String refreshAccessToken(String refreshToken) {
	        // Validar el Refresh Token
	        if (!validateToken(refreshToken)) {
	            throw new RuntimeException("Refresh Token inválido o expirado");
	        }

	        // Extraer el username del Refresh Token
	        String username = getUsername(refreshToken);

	        // Obtener el usuario desde la base de datos
	        Usuario usuario = usuarioRepository.findByUsername(username)
	                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

	        // Obtener todos los roles del usuario
	        String roles = usuario.getRoles().stream()
	                .map(rol -> "ROLE_" + rol.getNombre()) // Asegura el prefijo
	                .collect(Collectors.joining(","));

	        // Generar un nuevo Access Token con los mismos campos personalizados
	        Date currentDate = new Date();
	        Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate);

	        return Jwts.builder()
	                .setSubject(username) // Asigna el username como subject
	                .claim("roles", roles) // Agrega los roles al payload
	                .setIssuedAt(currentDate) // Fecha de creación del token
	                .setExpiration(expireDate) // Fecha de expiración
	                .signWith(key(), SignatureAlgorithm.HS256) // Firma con la clave
	                .compact(); // Genera el token
	    }
	
	
	    private Key key() {
	        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
	    }
	
	    // Extraer username del JWT token
	    public String getUsername(String token) {
	        return Jwts.parser()
	                .verifyWith((SecretKey) key())
	                .build()
	                .parseSignedClaims(token)
	                .getPayload()
	                .getSubject();
	    }
	
	    // Validar JWT token
	    public boolean validateToken(String token) {
	        try {
	            Jwts.parser()
	                    .verifyWith((SecretKey) key())
	                    .build()
	                    .parse(token);
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }
	}
