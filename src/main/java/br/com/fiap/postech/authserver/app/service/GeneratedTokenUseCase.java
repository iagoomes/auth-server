package br.com.fiap.postech.authserver.app.service;

import br.com.fiap.postech.authserver.domain.entity.Auth;
import br.com.fiap.postech.authserver.domain.entity.ClientCredentials;

public interface GeneratedTokenUseCase {
    Auth execute(ClientCredentials clientCredentials);
}
