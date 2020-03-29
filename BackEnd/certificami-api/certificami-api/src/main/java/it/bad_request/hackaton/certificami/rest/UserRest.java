package it.bad_request.hackaton.certificami.rest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.bad_request.hackaton.certificami.dto.InfoPersonaliDto;
import it.bad_request.hackaton.certificami.dto.LoginDto;
import it.bad_request.hackaton.certificami.dto.RegistrazioneDto;
import it.bad_request.hackaton.certificami.service.UserService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserRest {

	@Autowired
	UserService userService;
	
	private final static Logger log = LoggerFactory.getLogger(UserRest.class);

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> authenticate(@RequestBody LoginDto data) {
		log.info("Verificando credenziali...");
		try {
			
			if (data.getEmail() == null || data.getPsw() == null) {
				log.info("Dati obbligatori non presenti.");
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(data.getPsw().getBytes());
			String cryptedPww = new String(messageDigest.digest());
			log.info("Username:" + data.getEmail());
			log.info("Password in hash:" + cryptedPww);
			data.setPsw(cryptedPww);
			boolean check = userService.checkPassword(data);
			if (check == true) {
				log.info("Credenziali corrette");
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				log.info("Credenziali non corrette");
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		} catch (NoSuchAlgorithmException e) {
			log.error("Errore durante la verifica delle credenziali", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> register(@RequestBody RegistrazioneDto data) {
		log.info("Registrando utente...");
		try {

			if (data.getEmail() == null || data.getName() == null || data.getPsw() == null) {
				log.info("Dati obbligatori non presenti.");
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(data.getPsw().getBytes());
			String cryptedPww = new String(messageDigest.digest());
			log.info("Username:" + data.getEmail());
			log.info("Password in hash:" + cryptedPww);
			log.info("Nome:" + data.getName());
			
			data.setPsw(cryptedPww);
			Long idUser = userService.register(data);
			if (idUser != null) {
				log.info("Registrazione completata con successo");
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				log.info("Registrazione fallita");
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
		} catch (NoSuchAlgorithmException e) {
			log.error("Errore durante la registrazione dell'utente", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/information", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> saveInformation(@RequestBody InfoPersonaliDto data) {
		log.info("Salvando informazioni utente...");
		try {
			log.info("Username:" + data.getEmail());
			
			if(data.getDocs()==null || !userService.verificaDocumento(data.getDocs())) {
				log.info("Documento:"+data.getDocs());
				log.info("Documento non valido");
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			};
		
			Long idUser = userService.saveInformation(data);
			if (idUser != null) {
				log.info("Registrazione completata con successo");
				return new ResponseEntity<String>(data.getEmail(),HttpStatus.OK);
			} else {
				log.info("Registrazione fallita");
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			log.error("Errore durante la registrazione dell'utente", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@RequestMapping(value = "/information", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> saveInformation(@RequestParam("username") String username) {
		log.info("Recuperando informazioni utente...");
		try {
			if (username == null) {
				log.info("Username non presente");
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			;
			InfoPersonaliDto data = userService.getInformation(username);
			if (data != null) {
				log.info("Recupero dati completato con successo");
				return new ResponseEntity<String>(data.getEmail(),HttpStatus.OK);
			} else {
				log.info("Registrazione fallita");
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			log.error("Errore durante la registrazione dell'utente", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
