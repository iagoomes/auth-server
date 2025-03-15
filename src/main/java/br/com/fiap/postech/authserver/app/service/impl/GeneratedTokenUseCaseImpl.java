package br.com.fiap.postech.authserver.app.service.impl;

import br.com.fiap.postech.authserver.app.service.GeneratedTokenUseCase;
import br.com.fiap.postech.authserver.domain.ClientCredentialsProvider;
import br.com.fiap.postech.authserver.domain.entity.Auth;
import br.com.fiap.postech.authserver.domain.entity.ClientCredentials;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GeneratedTokenUseCaseImpl implements GeneratedTokenUseCase {

    private final ClientCredentialsProvider clientCredentialsProvider;

    @Override
    public Auth execute(ClientCredentials clientCredentials) {
        return clientCredentialsProvider.generateToken(clientCredentials);
    }
}
