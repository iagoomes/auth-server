package br.com.fiap.postech.authserver.infra.config;

import br.com.fiap.postech.authserver.infra.exception.SecretKeyNotFound;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "secret")
public class JwtUtil {

    private String key;

    public String generateToken(String clientId, SecretKey key) {
        return Jwts.builder()
                .setSubject(clientId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 10 * 60 * 1000))  // 10 minutes validity
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public SecretKey getSecretKey() {
        byte[] decodedKey = java.util.Base64.getDecoder().decode(extractSecretValue(key));
        return Keys.hmacShaKeyFor(decodedKey);
    }

    private String extractSecretValue(String key) {
        try {
            Path path = Path.of(key);
            if (Files.exists(path)) {
                return Files.readString(path).trim();
            }
            return key;
        } catch (IOException e) {
            throw new SecretKeyNotFound("Error reading secret value");
        }
    }
}