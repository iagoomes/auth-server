package br.com.fiap.postech.authserver.app.resource;

import br.com.fiap.postech.authserver.api.AuthApiDelegate;
import br.com.fiap.postech.authserver.app.service.TokenService;
import br.com.fiap.postech.authserver.model.AuthDTO;
import br.com.fiap.postech.authserver.model.ClientCredentialsDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthResource implements AuthApiDelegate {

    private final TokenService tokenService;

    @Override
    public CompletableFuture<ResponseEntity<AuthDTO>> generateToken(@RequestBody ClientCredentialsDTO credentials) {
        log.info("Generating new token to client {}", credentials.getClientId());
        return CompletableFuture.supplyAsync(() -> ResponseEntity.ok(tokenService.generateToken(credentials)));
    }
}