package br.dev.joao.hotelBooker.security;

import br.dev.joao.hotelBooker.admin.Admin;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    public String generateToken(Admin admin) {
        try {
            var algorithm = Algorithm.HMAC256("12345678");
            return JWT.create()
                    .withIssuer("API hotelBooker")
                    .withSubject(admin.getUsername())
                    .withExpiresAt(expiresIn())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Error to generate Token JWT", exception);
        }

    }

    public String getSubject(String tokenJWT) {
        try {
            var algorithm = Algorithm.HMAC256("12345678");
            return JWT.require(algorithm)
                    .withIssuer("API hotelBooker")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT invalid or expired!");
        }
    }
    private Instant expiresIn() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
