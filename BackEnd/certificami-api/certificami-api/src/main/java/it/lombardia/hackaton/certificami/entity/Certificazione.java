package it.lombardia.hackaton.certificami.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "certificazione")
public class Certificazione implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8806629275351298650L;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_utente")
	private Utente utente;

}
