package it.bad_request.hackaton.certificami.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conf_motivi")
public class Motivazione {

	
	@Id
	@Column(name = "id_tipo")
	private Long idMotivazione;
	
	@Column(name = "descrizione")
	private String descrizione;

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Long getIdMotivazione() {
		return idMotivazione;
	}

	public void setIdMotivazione(Long idMotivazione) {
		this.idMotivazione = idMotivazione;
	}
	
	
}
