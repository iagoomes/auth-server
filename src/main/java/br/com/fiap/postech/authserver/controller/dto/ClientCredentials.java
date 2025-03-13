package br.com.fiap.postech.authserver.controller.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ClientCredentials {
    private String clientId;
    private String clientSecret;
}