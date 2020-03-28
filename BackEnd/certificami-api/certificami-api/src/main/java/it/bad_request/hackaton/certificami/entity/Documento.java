package it.bad_request.hackaton.certificami.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conf_documenti")
public class Documento {
	
	@Id
	@Column(name = "id_tipo_d")
	private String idTipoD;
	
	@Column(name = "descrizione")
	private String descrizione;

	public String getIdTipoD() {
		return idTipoD;
	}

	public void setIdTipoD(String idTipoD) {
		this.idTipoD = idTipoD;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	
}
