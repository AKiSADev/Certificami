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
	private Long idTipoD;
	
	@Column(name = "descrizione")
	private String descrizione;

	public Long getIdTipoD() {
		return idTipoD;
	}

	public void setIdTipoD(Long idTipoD) {
		this.idTipoD = idTipoD;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	
}
