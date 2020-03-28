package it.lombardia.hackaton.certificami.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "utente")
public class Utente implements Serializable {
	private static final long serialVersionUID = 6924717610205568206L;

	@Id
	@Column(name = "id_utente")
	long idUtente;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "utente")
	private List<Certificazione> certificazione;

}
