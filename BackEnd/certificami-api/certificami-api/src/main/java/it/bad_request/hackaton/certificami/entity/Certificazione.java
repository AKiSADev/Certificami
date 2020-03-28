package it.bad_request.hackaton.certificami.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "autocertificazioni")
public class Certificazione implements Serializable {

	private static final long serialVersionUID = -8806629275351298650L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cert")
	private Long idCert;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utente")
	private Utente utente;

	@Column(name = "spostamento_da")
	private String da;
	
	@Column(name = "spostamento_a")
	private String a;
	
	@Column(name = "regione_partenza")
	private String regionePartenza;
	
	@Column(name = "regione_arrivo")
	private String regioneArrivo;
	
	@Column(name = "provvedimento")
	private String provvedimento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "motivazione") 
	private Motivazione motivazione;
	
	
	@Column(name = "dichiara_che")
	private String dichiarazione;
	
	@Column(name = "dati_aggiuntivi")
	private String dati_aggiuntivi;
	
	@Column(name = "data_ora_creazione")
	private LocalDateTime dataCreazione;
	
	@Column(name = "data_ora_validazione")
	private LocalDateTime dataValidazione;
	
	@Column(name = "id_utente_controllore")
	private Utente utenteControllore;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_documento")
	private Documento documento;
	
	@Column(name = "numero_documento")
	private String numeroDocumento;
	
	@Column(name = "rilasciato_da")
	private String rilasciatoDa;
	
	@Column(name = "data_rilascio")
	private String dataRilascio;

	public Long getIdCert() {
		return idCert;
	}

	public void setIdCert(Long idCert) {
		this.idCert = idCert;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public String getDa() {
		return da;
	}

	public void setDa(String da) {
		this.da = da;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getRegionePartenza() {
		return regionePartenza;
	}

	public void setRegionePartenza(String regionePartenza) {
		this.regionePartenza = regionePartenza;
	}

	public String getRegioneArrivo() {
		return regioneArrivo;
	}

	public void setRegioneArrivo(String regioneArrivo) {
		this.regioneArrivo = regioneArrivo;
	}

	public String getProvvedimento() {
		return provvedimento;
	}

	public void setProvvedimento(String provvedimento) {
		this.provvedimento = provvedimento;
	}

//	public Motivazione getMotivazione() {
//		return motivazione;
//	}
//
//	public void setMotivazione(Motivazione motivazione) {
//		this.motivazione = motivazione;
//	}

	public String getDichiarazione() {
		return dichiarazione;
	}

	public void setDichiarazione(String dichiarazione) {
		this.dichiarazione = dichiarazione;
	}

	public String getDati_aggiuntivi() {
		return dati_aggiuntivi;
	}

	public void setDati_aggiuntivi(String dati_aggiuntivi) {
		this.dati_aggiuntivi = dati_aggiuntivi;
	}

	public LocalDateTime getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(LocalDateTime dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public LocalDateTime getDataValidazione() {
		return dataValidazione;
	}

	public void setDataValidazione(LocalDateTime dataValidazione) {
		this.dataValidazione = dataValidazione;
	}

	public Utente getUtenteControllore() {
		return utenteControllore;
	}

	public void setUtenteControllore(Utente utenteControllore) {
		this.utenteControllore = utenteControllore;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getRilasciatoDa() {
		return rilasciatoDa;
	}

	public void setRilasciatoDa(String rilasciatoDa) {
		this.rilasciatoDa = rilasciatoDa;
	}

	public String getDataRilascio() {
		return dataRilascio;
	}

	public void setDataRilascio(String dataRilascio) {
		this.dataRilascio = dataRilascio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Motivazione getMotivazione() {
		return motivazione;
	}

	public void setMotivazione(Motivazione motivazione) {
		this.motivazione = motivazione;
	}
	
	
	

}
