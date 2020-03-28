package it.bad_request.hackaton.certificami.util;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import it.bad_request.hackaton.certificami.dto.RagioniSpostamento;
import it.bad_request.hackaton.certificami.entity.Certificazione;


@Component
public class CertificazioneConverter implements Converter<RagioniSpostamento, Certificazione>{

	@Override
	public Certificazione convert(RagioniSpostamento source) {
		
		Certificazione c = new Certificazione();
		
		c.setA(source.getMoveStreetEnd());
		c.setDa(source.getMoveStreetStart());
		c.setRegioneArrivo(source.getMoveRegEnd());
		c.setRegionePartenza(source.getMoveRegStart());
		c.setProvvedimento(source.getRagioneText());
		c.setDichiarazione(source.getRagioneOptionText());
		
		
		return c;
	}

}
