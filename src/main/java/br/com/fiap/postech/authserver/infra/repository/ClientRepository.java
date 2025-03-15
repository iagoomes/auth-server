package br.com.fiap.postech.authserver.infra.repository;

import br.com.fiap.postech.authserver.infra.repository.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
}
