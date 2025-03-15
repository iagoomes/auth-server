package br.com.fiap.postech.authserver.domain;

import br.com.fiap.postech.authserver.domain.entity.Auth;
import br.com.fiap.postech.authserver.domain.entity.ClientCredentials;

public interface ClientCredentialsProvider {
    void validate(String clientId, String clientSecret);
    Auth generateToken(ClientCredentials clientCredentials);
}
