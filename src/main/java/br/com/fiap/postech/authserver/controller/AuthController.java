package br.com.fiap.postech.authserver.controller;

import br.com.fiap.postech.authserver.config.JwtUtil;
import br.com.fiap.postech.authserver.controller.dto.AuthResponse;
import br.com.fiap.postech.authserver.controller.dto.ClientCredentials;
import br.com.fiap.postech.authserver.service.ClientCredentialsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final ClientCredentialsService credentialsService;
    private final JwtUtil jwtUtil;

    @PostMapping("/api/token")
    public ResponseEntity<?> authenticateClient(@RequestBody ClientCredentials credentials) throws IOException {
        if (credentialsService.validateCredentials(credentials)) {
            SecretKey secretKey = jwtUtil.getSecretKey();
            String token = jwtUtil.generateToken(credentials.getClientId(), secretKey);
            return ResponseEntity.ok(new AuthResponse(token));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
}