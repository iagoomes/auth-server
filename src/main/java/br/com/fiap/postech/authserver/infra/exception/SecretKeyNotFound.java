package br.com.fiap.postech.authserver.infra.exception;

public class SecretKeyNotFound extends RuntimeException {
    public SecretKeyNotFound(String message) {
        super(message);
    }
}
