package br.com.fiap.postech.authserver.app.service;

import br.com.fiap.postech.authserver.model.AuthDTO;
import br.com.fiap.postech.authserver.model.ClientCredentialsDTO;

public interface TokenService {
    AuthDTO generateToken(ClientCredentialsDTO credentials);
}
