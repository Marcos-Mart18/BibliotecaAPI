package upeu.edu.pe.BibliotecaAPI.ServiceImpl;

import upeu.edu.pe.BibliotecaAPI.config.JwtTokenProvider;
import upeu.edu.pe.BibliotecaAPI.dto.LoginDto;
import upeu.edu.pe.BibliotecaAPI.dto.RegisterDto;
import upeu.edu.pe.BibliotecaAPI.Entity.RefreshToken;
import upeu.edu.pe.BibliotecaAPI.Entity.Rol;
import upeu.edu.pe.BibliotecaAPI.Entity.Usuario;
import upeu.edu.pe.BibliotecaAPI.Repository.RolRepository;
import upeu.edu.pe.BibliotecaAPI.Repository.UsuarioRepository;
import upeu.edu.pe.BibliotecaAPI.Service.AuthService;
import upeu.edu.pe.BibliotecaAPI.Dao.RefreshTokenDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.*;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private RefreshTokenDao refreshTokenDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Map<String, String> login(LoginDto loginDto) {
        // 1. Autenticar usuario
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 2. Buscar el usuario para incluir datos adicionales en los tokens
        Usuario usuario = usuarioRepository.findByUsername(loginDto.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // 3. Generar Access Token
        String accessToken = jwtTokenProvider.generateToken(authentication);

        // 4. Generar Refresh Token
        String refreshToken = jwtTokenProvider.generateRefreshToken(usuario.getUsername());

        // 5. Guardar Refresh Token en la base de datos
        RefreshToken tokenEntity = new RefreshToken();
        tokenEntity.setToken(refreshToken);
        tokenEntity.setUsuario(usuario);
        tokenEntity.setExpiryDate(new Date(System.currentTimeMillis() + 604800000)); 
        refreshTokenDao.save(tokenEntity);

        // 6. Retornar ambos tokens
        Map<String, String> tokens = new HashMap<>();
        tokens.put("accessToken", accessToken);
        tokens.put("refreshToken", refreshToken);

        return tokens;
    }

    @Override
    public String register(RegisterDto registerDto) {

        // Verificar si el usuario ya existe
        if (usuarioRepository.existsByUsername(registerDto.getUsername())) {
            throw new RuntimeException("El usuario ya existe");
        }

        // Crear el usuario
        Usuario usuario = new Usuario();
        usuario.setUsername(registerDto.getUsername());
        usuario.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        usuario.setEstado('A'); // Estado por defecto activo

        // Buscar el rol en la base de datos
        Rol userRole = rolRepository.findByNombre(registerDto.getRoleName())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado: " + registerDto.getRoleName()));

        // Agregar el rol al usuario
        usuario.getRoles().add(userRole);

        // Guardar el usuario en la base de datos
        usuarioRepository.save(usuario);

        return "Usuario registrado con éxito con el rol: " + registerDto.getRoleName();
    }



    @Override
    public Usuario findUserByUsername(String username) {
        return usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    @Transactional
    public void logout(String refreshToken) {
        refreshTokenDao.deleteByToken(refreshToken);
    }

    @Override
    public String refreshAccessToken(String refreshToken) {
        return jwtTokenProvider.refreshAccessToken(refreshToken);
    }

}
