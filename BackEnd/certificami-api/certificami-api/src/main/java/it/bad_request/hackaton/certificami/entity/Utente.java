package it.bad_request.hackaton.certificami.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "utenti")
public class Utente implements Serializable {
	private static final long serialVersionUID = 6924717610205568206L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_utente")
	private Long idUtente;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cognome")
	private String cognome;
	
	@Column(name = "numero_telefono")
	private String numeroTelefono;
	
	@Column(name = "data_nascita")
	private LocalDate dataNascita;
	
	@Column(name = "comune_nascita")
	private String comuneNascita;
	
	@Column(name = "provincia_nascita")
	private String provinciaNascita;
	
	@Column(name = "via_residenza")
	private String viaResidenza;
	
	@Column(name = "comune_residenza")
	private String comuneResidenza;
	
	@Column(name = "provincia_residenza")
	private String provinciaResidenza;
	
	@Column(name = "via_domicilio")
	private String viaDomicilio;
	
	@Column(name = "provincia_domicilio")
	private String provinciaDomicilio;
	
	@Column(name = "comune_domicilio")
	private String comuneDomicilio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_utente")
	private TipoUtente tipoUtente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_documento")
	private Documento tipoDocumento;
	
	@Column(name = "numero_documento")
	private String numeroDocumento;
	
	@Column(name = "rilasciato_da")
	private String rilasciatoDa;
	
	@Column(name = "data_documento")
	private LocalDate dataDocumento;
	
	@Column(name = "e_mail")
	private String eMail;

	
	public Long getIdUtente() {
		return idUtente;
	}



	public void setIdUtente(Long idUtente) {
		this.idUtente = idUtente;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCognome() {
		return cognome;
	}



	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public String getNumeroTelefono() {
		return numeroTelefono;
	}



	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}



	public LocalDate getDataNascita() {
		return dataNascita;
	}



	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}



	public String getComuneNascita() {
		return comuneNascita;
	}



	public void setComuneNascita(String comuneNascita) {
		this.comuneNascita = comuneNascita;
	}



	public String getProvinciaNascita() {
		return provinciaNascita;
	}



	public void setProvinciaNascita(String provinciaNascita) {
		this.provinciaNascita = provinciaNascita;
	}



	public String getViaResidenza() {
		return viaResidenza;
	}



	public void setViaResidenza(String viaResidenza) {
		this.viaResidenza = viaResidenza;
	}



	public String getComuneResidenza() {
		return comuneResidenza;
	}



	public void setComuneResidenza(String comuneResidenza) {
		this.comuneResidenza = comuneResidenza;
	}



	public String getProvinciaResidenza() {
		return provinciaResidenza;
	}



	public void setProvinciaResidenza(String provinciaResidenza) {
		this.provinciaResidenza = provinciaResidenza;
	}



	public String getViaDomicilio() {
		return viaDomicilio;
	}



	public void setViaDomicilio(String viaDomicilio) {
		this.viaDomicilio = viaDomicilio;
	}



	public String getProvinciaDomicilio() {
		return provinciaDomicilio;
	}



	public void setProvinciaDomicilio(String provinciaDomicilio) {
		this.provinciaDomicilio = provinciaDomicilio;
	}



	public String getComuneDomicilio() {
		return comuneDomicilio;
	}



	public void setComuneDomicilio(String comuneDomicilio) {
		this.comuneDomicilio = comuneDomicilio;
	}



//	public TipoUtente getTipoUtente() {
//		return tipoUtente;
//	}
//
//
//
//	public void setTipoUtente(TipoUtente tipoUtente) {
//		this.tipoUtente = tipoUtente;
//	}



//	public Documento getTipoDocumento() {
//		return tipoDocumento;
//	}
//
//
//
//	public void setTipoDocumento(Documento tipoDocumento) {
//		this.tipoDocumento = tipoDocumento;
//	}



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



	public LocalDate getDataDocumento() {
		return dataDocumento;
	}



	public void setDataDocumento(LocalDate dataDocumento) {
		this.dataDocumento = dataDocumento;
	}



	public List<Certificazione> getCertificazione() {
		return certificazione;
	}



	public void setCertificazione(List<Certificazione> certificazione) {
		this.certificazione = certificazione;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public TipoUtente getTipoUtente() {
		return tipoUtente;
	}



	public void setTipoUtente(TipoUtente tipoUtente) {
		this.tipoUtente = tipoUtente;
	}



	public Documento getTipoDocumento() {
		return tipoDocumento;
	}



	public void setTipoDocumento(Documento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}



	public String geteMail() {
		return eMail;
	}



	public void seteMail(String eMail) {
		this.eMail = eMail;
	}



	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "utente")
	private List<Certificazione> certificazione;

}
