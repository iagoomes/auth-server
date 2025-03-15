package br.com.fiap.postech.authserver.infra.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "CLIENTS")
public class Client {
    @Id
    @Column(name = "client_id")
    private String id;

    @Column(name = "client_secret")
    private String secret;
}
