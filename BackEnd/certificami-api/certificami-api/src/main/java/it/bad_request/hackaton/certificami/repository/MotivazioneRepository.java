package it.bad_request.hackaton.certificami.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.bad_request.hackaton.certificami.entity.Certificazione;
import it.bad_request.hackaton.certificami.entity.Motivazione;

public interface MotivazioneRepository extends JpaRepository<Motivazione, Long>{

}
