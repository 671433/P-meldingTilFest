package com.hvl.no.Oblig4.model;




import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="deltager", schema ="deltager")
public class Deltager {
	
	@Id
	@NotNull
	@Pattern(regexp = "\\d{8}", message = "Mobil nummer må være 8 nummer")
	private String mobil;
	
	@NotNull
	@Size(min=2, max=30, message="Fornavn må være mellom 2 og 30 tegn")
	@Pattern(regexp= "^[A-ZÆØÅ][a-zæøå-]+(?: [a-zæøå-]+)*$", message="Fornavn som begynner med store bokstaver, deretter små bokstaver og bindestrek, atskilt med mellomrom")
	private String fornavn;
	
	@NotNull
	@Size(min=2, max=30, message="Etternavn må være mellom 2 og 30 tegn")
	@Pattern(regexp="^[A-ZÆØÅ][a-zæøå-]+$",message = "Etternavn som begynner med store bokstaver og deretter små bokstaver og bindestreker, ingen mellomrom")
	private String etternavn;
	
	@NotNull(message ="Passord kan ikke være tomt")
	private String hash;
	
	@NotNull(message ="Skriv inn det samme passordet på nytt")
	private String salt;
	
	@NotNull(message ="Kjønn kan ikke være tomt , valg enten man elle kvinne")
	private String kjonn;

	public Deltager( String mobil,String fornavn, String etternavn, String hash,String salt, String kjonn) {
		super();
		this.mobil = mobil;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.hash = hash;
		this.salt = salt;
		this.kjonn = kjonn;
	}
	
	

	public Deltager() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}

	

	
	

}
