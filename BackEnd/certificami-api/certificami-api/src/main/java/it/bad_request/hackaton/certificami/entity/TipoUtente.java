package it.bad_request.hackaton.certificami.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conf_tipo_utente")
public class TipoUtente {

	
	@Id
	@Column(name = "id_tipo")
	private Long idTipo;
	
	@Column(name = "descrizione")
	private String descrizione;

	public Long getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Long idTipo) {
		this.idTipo = idTipo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
	
}
