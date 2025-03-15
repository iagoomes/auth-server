package br.com.fiap.postech.authserver.infra.exception;

import br.com.fiap.postech.authserver.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex) {
        log.error("Exception: ", ex);
        ErrorResponse errorResponse = new ErrorResponse()
                .traceId(UUID.randomUUID().toString())
                .timestamp(OffsetDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME))
                .message(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SecretKeyNotFound.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(SecretKeyNotFound ex) {
        log.error("SecretKeyNotFound: ", ex);
        ErrorResponse errorResponse = new ErrorResponse()
                .traceId(UUID.randomUUID().toString())
                .timestamp(OffsetDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME))
                .message(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorResponse> handleInvalidTokenException(UnauthorizedException ex) {
        log.error("UnauthorizedException: ", ex);
        ErrorResponse errorResponse = new ErrorResponse()
                .traceId(UUID.randomUUID().toString())
                .timestamp(OffsetDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME))
                .message(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }
}