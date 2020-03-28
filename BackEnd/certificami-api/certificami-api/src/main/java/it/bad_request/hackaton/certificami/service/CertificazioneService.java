package it.bad_request.hackaton.certificami.service;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.bad_request.hackaton.certificami.dto.RagioniSpostamento;
import it.bad_request.hackaton.certificami.entity.Certificazione;
import it.bad_request.hackaton.certificami.entity.Motivazione;
import it.bad_request.hackaton.certificami.entity.Utente;
import it.bad_request.hackaton.certificami.repository.CertificazioneRepository;
import it.bad_request.hackaton.certificami.repository.MotivazioneRepository;
import it.bad_request.hackaton.certificami.repository.UtenteRepository;
import it.bad_request.hackaton.certificami.util.CertificazioneConverter;

@Service
public class CertificazioneService {

	@Autowired
	CertificazioneRepository certificazioneRepository;

	@Autowired
	CertificazioneConverter certificazioneConverter;

	@Autowired
	MotivazioneRepository motivazioneRepository;

	@Autowired
	UtenteRepository utenteRepository;
	
	public Certificazione createCertification(RagioniSpostamento ragioniSpostamento) {

		Certificazione cert = new Certificazione();

		try {

			cert = certificazioneConverter.convert(ragioniSpostamento);

			Motivazione motivazione = motivazioneRepository
					.findById(Long.parseLong(ragioniSpostamento.getRagioneOption())).orElse(null);
			cert.setMotivazione(motivazione);

			Utente utente = utenteRepository.findByUsernameIgnoreCase(ragioniSpostamento.getEmail());
			
			cert.setUtente(utente);

			cert.setDataCreazione(LocalDateTime.now(ZoneId.of("Europe/Rome")));
			cert = certificazioneRepository.save(cert);

			return cert;

		} catch (Exception e) {
			return null;
		}
	}

	public Certificazione findCertificazioneById(Long idCert) {
		
		return certificazioneRepository.findById(idCert).orElse(null);
	}
}
