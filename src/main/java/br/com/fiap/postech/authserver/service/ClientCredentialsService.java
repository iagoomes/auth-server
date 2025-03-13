package br.com.fiap.postech.authserver.service;

import br.com.fiap.postech.authserver.controller.dto.ClientCredentials;
import org.springframework.stereotype.Service;

@Service
public class ClientCredentialsService {

    public boolean validateCredentials(ClientCredentials credentials) {
        // Implementar lógica de validação de credenciais
        return true;  // Simulação
    }
}