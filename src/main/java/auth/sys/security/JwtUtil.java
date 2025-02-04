package auth.sys.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private String SECRET_KEY = "seuSegredoSuperSecreto"; // Chave secreta para assinar o token

    // Gera um token JWT
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username) // Define o assunto (normalmente o nome de usuário)
                .setIssuedAt(new Date()) // Define a data de emissão
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 24 horas de expiração
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // Assina o token com a chave secreta
                .compact(); // Converte para uma string
    }

    // Extrai o nome de usuário do token
    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY) // Define a chave secreta para validar o token
                .parseClaimsJws(token) // Faz o parsing do token
                .getBody() // Obtém o corpo do token (claims)
                .getSubject(); // Obtém o assunto (nome de usuário)
    }

    // Valida o token
    public boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    // Verifica se o token expirou
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Extrai a data de expiração do token
    private Date extractExpiration(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
    }
}
