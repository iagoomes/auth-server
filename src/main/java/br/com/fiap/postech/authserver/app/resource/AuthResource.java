package br.com.fiap.postech.authserver.app.resource;

import br.com.fiap.postech.authserver.api.AuthApiDelegate;
import br.com.fiap.postech.authserver.app.service.TokenService;
import br.com.fiap.postech.authserver.model.AuthDTO;
import br.com.fiap.postech.authserver.model.ClientCredentialsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class AuthResource implements AuthApiDelegate {

    private final TokenService tokenService;

    @Override
    public CompletableFuture<ResponseEntity<AuthDTO>> generateToken(@RequestBody ClientCredentialsDTO credentials) {
        return CompletableFuture.supplyAsync(() -> ResponseEntity.ok(tokenService.generateToken(credentials)));
    }
}