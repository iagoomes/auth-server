package br.com.fiap.postech.authserver.domain.usecase;

import br.com.fiap.postech.authserver.domain.ClientCredentialsProvider;
import br.com.fiap.postech.authserver.domain.entity.ClientCredentials;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientCredentialsValidateUseCase {
    private final ClientCredentialsProvider clientCredentialsProvider;

    public void execute(ClientCredentials credentials) {
        clientCredentialsProvider.validate(credentials.clientId(), credentials.clientSecret());
    }
}