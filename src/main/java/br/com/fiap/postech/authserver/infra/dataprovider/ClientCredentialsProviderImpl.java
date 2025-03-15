package br.com.fiap.postech.authserver.infra.dataprovider;

import br.com.fiap.postech.authserver.domain.ClientCredentialsProvider;
import br.com.fiap.postech.authserver.domain.entity.Auth;
import br.com.fiap.postech.authserver.domain.entity.ClientCredentials;
import br.com.fiap.postech.authserver.infra.config.JwtUtil;
import br.com.fiap.postech.authserver.infra.exception.UnauthorizedException;
import br.com.fiap.postech.authserver.infra.repository.ClientRepository;
import br.com.fiap.postech.authserver.infra.repository.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
@RequiredArgsConstructor
public class ClientCredentialsProviderImpl implements ClientCredentialsProvider {

    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public void validate(String clientId, String clientSecret) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new UnauthorizedException("Invalid credentials"));
        boolean matches = passwordEncoder.matches(clientSecret, client.getSecret());
        if (!matches) {
            throw new UnauthorizedException("Invalid credentials");
        }
    }

    @Override
    public Auth generateToken(ClientCredentials clientCredentials) {
        SecretKey secretKey = jwtUtil.getSecretKey();
        String token = jwtUtil.generateToken(clientCredentials.clientId(), secretKey);
        return new Auth(token);
    }
}
