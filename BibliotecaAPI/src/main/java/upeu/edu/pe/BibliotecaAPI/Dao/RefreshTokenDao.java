package upeu.edu.pe.BibliotecaAPI.Dao;

import upeu.edu.pe.BibliotecaAPI.Entity.RefreshToken;

import java.util.Optional;

public interface RefreshTokenDao {
    Optional<RefreshToken> findByToken(String token);
    void deleteByToken(String token);
    void deleteByUsuarioId(Long userId);
    RefreshToken save(RefreshToken refreshToken);
}
