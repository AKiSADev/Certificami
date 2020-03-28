package it.bad_request.hackaton.certificami.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.bad_request.hackaton.certificami.dto.InfoPersonaliDto;
import it.bad_request.hackaton.certificami.dto.LoginDto;
import it.bad_request.hackaton.certificami.dto.RegistrazioneDto;
import it.bad_request.hackaton.certificami.entity.Documento;
import it.bad_request.hackaton.certificami.entity.TipoUtente;
import it.bad_request.hackaton.certificami.entity.Utente;
import it.bad_request.hackaton.certificami.repository.DocumentoRepository;
import it.bad_request.hackaton.certificami.repository.TipoUtenteRepository;
import it.bad_request.hackaton.certificami.repository.UtenteRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	UtenteRepository utenteRepository;

	@Autowired
	DocumentoRepository documentoRepository;
	@Autowired
	TipoUtenteRepository tipoUtenteRepository;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public boolean checkPassword(LoginDto data) {
		Utente utente = utenteRepository.findByUsernameIgnoreCase(data.getEmail());
		if (utente == null || !data.getPsw().equals(utente.getPassword())) {
			return false;
		}
		return true;
	}

	public Long register(RegistrazioneDto data) {
		Utente utente = utenteRepository.findByUsernameIgnoreCase(data.getEmail());
		if (utente == null) {
			utente = new Utente();
			utente.setNome(data.getName());
			utente.setUsername(data.getEmail());
			utente.setPassword(data.getPsw());
			utente = utenteRepository.save(utente);
			return utente.getIdUtente();
		} else {
			return null;
		}
	}

	public Long saveInformation(InfoPersonaliDto data) {
		Utente utente = utenteRepository.findByUsernameIgnoreCase(data.getEmail());
		if (utente == null) {
			utente = new Utente();

			utente.setComuneDomicilio(data.getDomCity());
			utente.setComuneNascita(data.getBornCity());
			utente.setComuneResidenza(data.getHomeCity());
			utente.setProvinciaDomicilio(data.getDomProv());
			utente.setProvinciaNascita(data.getBornProv());
			utente.setProvinciaResidenza(data.getHomeProv());
			utente.setNumeroTelefono(data.getPhone());
			utente.setNumeroDocumento(data.getDocsCode());
			utente.setNumeroTelefono(data.getPhone());
			utente.setDataNascita(LocalDate.parse(data.getBornDate(), formatter));
			utente.setDataDocumento(LocalDate.parse(data.getDocsRelase(), formatter));
			utente.setViaDomicilio(data.getDomStreet());
			utente.setViaResidenza(data.getHomeStreet());

			Documento tipoDocumento = documentoRepository.findByIdTipoDIgnoreCase(data.getDocs());
			utente.setTipoDocumento(tipoDocumento);

			Optional<TipoUtente> tipoUtenteOpt = tipoUtenteRepository.findById("USR");
			if (tipoUtenteOpt.isPresent()) {
				utente.setTipoUtente(tipoUtenteOpt.get());
			}

			utente = utenteRepository.save(utente);
			return utente.getIdUtente();
		} else {
			return null;
		}
	}

	public InfoPersonaliDto getInformation(String username) {
		Utente utente = utenteRepository.findByUsernameIgnoreCase(username);
		InfoPersonaliDto data = new InfoPersonaliDto();
		if (utente != null) {
			data.setDomCity(utente.getComuneDomicilio());
			data.setBornCity(utente.getComuneNascita());
			data.setHomeCity(utente.getComuneResidenza());
			data.setDomProv(utente.getProvinciaDomicilio());
			data.setBornProv(utente.getProvinciaNascita());
			data.setHomeProv(utente.getProvinciaResidenza());
			data.setPhone(utente.getNumeroTelefono());
			data.setDocsCode(utente.getNumeroDocumento());
			data.setPhone(utente.getNumeroTelefono());
			data.setBornDate(utente.getDataNascita() != null ? utente.getDataNascita().format(formatter) : null);
			data.setDocsRelase(utente.getDataDocumento() != null ? utente.getDataDocumento().format(formatter) : null);
			data.setDomStreet(utente.getViaDomicilio());
			data.setHomeStreet(utente.getViaResidenza());
			data.setDocs(utente.getTipoDocumento().getIdTipoD());
			return data;
		} else {
			return null;
		}
	}

	public boolean verificaDocumento(String tipoDocumento) {
		Documento documento = documentoRepository.findByIdTipoDIgnoreCase(tipoDocumento);

		if (documento == null) {
			return false;
		} else {
			return true;
		}

	}

}