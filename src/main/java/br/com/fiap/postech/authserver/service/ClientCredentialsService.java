package br.com.fiap.postech.authserver.service;

import br.com.fiap.postech.authserver.controller.dto.ClientCredentials;
import br.com.fiap.postech.authserver.model.Client;
import br.com.fiap.postech.authserver.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientCredentialsService {
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean validateCredentials(ClientCredentials credentials) {
        Client client = clientRepository.findById(credentials.getClientId()).orElse(null);
        if (client != null) {
            return passwordEncoder.matches(credentials.getClientSecret(), client.getSecret());
        }
        return false;
    }
}