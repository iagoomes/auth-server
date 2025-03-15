package br.com.fiap.postech.authserver.app.mapper;

import br.com.fiap.postech.authserver.domain.entity.Auth;
import br.com.fiap.postech.authserver.domain.entity.ClientCredentials;
import br.com.fiap.postech.authserver.model.AuthDTO;
import br.com.fiap.postech.authserver.model.ClientCredentialsDTO;
import org.springframework.stereotype.Component;

@Component
public class ClientCredentialsMapper {
    public ClientCredentials toModel(ClientCredentialsDTO credentials) {
        return new ClientCredentials(credentials.getClientId(), credentials.getClientSecret());
    }

    public AuthDTO toDTO(Auth auth) {
        return new AuthDTO(auth.token());
    }
}
