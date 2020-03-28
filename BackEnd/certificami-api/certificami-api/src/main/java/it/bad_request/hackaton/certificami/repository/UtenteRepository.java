package it.bad_request.hackaton.certificami.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.bad_request.hackaton.certificami.entity.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Long> {

	Utente findByUsernameIgnoreCase(String username);

}
