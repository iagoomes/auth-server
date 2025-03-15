package br.com.fiap.postech.authserver.app.service.impl;

import br.com.fiap.postech.authserver.app.mapper.ClientCredentialsMapper;
import br.com.fiap.postech.authserver.app.service.GeneratedTokenUseCase;
import br.com.fiap.postech.authserver.app.service.TokenService;

import br.com.fiap.postech.authserver.domain.entity.ClientCredentials;
import br.com.fiap.postech.authserver.model.AuthDTO;
import br.com.fiap.postech.authserver.model.ClientCredentialsDTO;
import br.com.fiap.postech.authserver.domain.usecase.ClientCredentialsValidateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {

    private final ClientCredentialsValidateUseCase clientCredentialsValidateUseCase;
    private final GeneratedTokenUseCase generatedTokenUseCase;
    private final ClientCredentialsMapper mapper;

    @Override
    public AuthDTO generateToken(ClientCredentialsDTO credentials) {
        ClientCredentials model = mapper.toModel(credentials);
        clientCredentialsValidateUseCase.execute(model);
        return mapper.toDTO(generatedTokenUseCase.execute(model));
    }
}
