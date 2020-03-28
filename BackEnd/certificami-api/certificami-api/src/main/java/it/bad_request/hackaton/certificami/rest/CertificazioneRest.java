package it.bad_request.hackaton.certificami.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.bad_request.hackaton.certificami.dto.RagioniSpostamento;
import it.bad_request.hackaton.certificami.entity.Certificazione;
import it.bad_request.hackaton.certificami.service.CertificazioneService;

@RestController
@RequestMapping("/certificate")
public class CertificazioneRest {

	@Autowired
	CertificazioneService certificazioneService;

	
	@PostMapping("/newcertificate")
	public ResponseEntity<String> createCertification(RagioniSpostamento ragioniSpostamento){
		
		String response = "KO";
		HttpStatus http;
		
		try {
			
			Certificazione cert = certificazioneService.createCertification(ragioniSpostamento);
			
			if (cert != null) {
				response = cert.getIdCert().toString();
				http = HttpStatus.OK;
				
			}else {
				http = HttpStatus.INTERNAL_SERVER_ERROR;
			}
				 
			return new ResponseEntity<String>(response, http);
		}catch(Exception e) {
			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/getcertificate/{idCert}")
	public ResponseEntity<Certificazione> getCertificate(Long idCert){
		
		String response = "KO";
		HttpStatus http;
		
		try {
			
			Certificazione cert = certificazioneService.findCertificazioneById(idCert);
			
			if (cert != null) {
				http = HttpStatus.OK;
				
			}else {
				http = HttpStatus.NOT_FOUND;
			}
				 
			return new ResponseEntity<Certificazione>(cert, http);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}
