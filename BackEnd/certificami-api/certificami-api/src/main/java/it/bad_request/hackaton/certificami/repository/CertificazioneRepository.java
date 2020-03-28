package it.bad_request.hackaton.certificami.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.bad_request.hackaton.certificami.entity.Certificazione;

public interface CertificazioneRepository extends JpaRepository<Certificazione, Long>{

}
