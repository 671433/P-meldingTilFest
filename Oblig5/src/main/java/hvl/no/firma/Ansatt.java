package hvl.no.firma;

import java.time.LocalDate;
import java.util.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Ansatt {
	
	@NotNull(message ="fornavn må kan ikke vøre tomt")
	@Size(min=2 , max=12 , message ="fornavn må vøre minst 2 tegen og max 12 tegn")
	@Pattern(regexp = "^[A-ZÆØÅa-zæøå -]$")
	private String fornavn;
	
	@NotNull(message ="etternavn må kan ikke vøre tomt")
	@Size(min=2 , max=12 , message ="etternavn må vøre minst 2 tegen og max 12 tegn")
	@Pattern(regexp="^[A-ZÆØÅa-zæøå-]$")
	private String etternavn;
	
	@Past
	@NotNull(message ="fodelsdato må kan ikke vøre tomt")
	private LocalDate fodelsdato;
	
	@Pattern(regexp="^[MK]$" ,message = "Kjønn må være enten 'M' eller 'K'")
	private char kjonn;
	
	@Min(value=2020, message ="startDato må vøre minst 2020")
	private LocalDate startDato;
	
	@Pattern(regexp="SJEF|UTVIKLER|ØKONOM" , message ="Ugyldig stilling. Tillatte verdier: Sjef, Utvikler, Økonom")
	private Stilling stilling;
	
	@Min(value=10_000, message ="maanedsLonn må være minst 10000")
	@Max(value= 200_000, message ="maanedsLonn må være max 200000")
	private Integer maanedsLonn;

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

	public LocalDate getFodelsdato() {
		return fodelsdato;
	}

	public void setFodelsdato(LocalDate fodelsdato) {
		this.fodelsdato = fodelsdato;
	}

	public char getKjonn() {
		return kjonn;
	}

	public void setKjonn(char kjonn) {
		this.kjonn = kjonn;
	}

	public LocalDate getStartDato() {
		return startDato;
	}

	public void setStartDato(LocalDate startDato) {
		this.startDato = startDato;
	}

	public Stilling getStilling() {
		return stilling;
	}

	public void setStilling(Stilling stilling) {
		this.stilling = stilling;
	}

	public Integer getMaanedsLonn() {
		return maanedsLonn;
	}

	public void setMaanedsLonn(Integer maanedsLonn) {
		this.maanedsLonn = maanedsLonn;
	}

	public Ansatt(
			@NotNull(message = "fornavn må kan ikke vøre tomt") @Size(min = 2, max = 12, message = "fornavn må vøre minst 2 tegen og max 12 tegn") @Pattern(regexp = "^[A-ZÆØÅa-zæøå -]$") String fornavn,
			@NotNull(message = "etternavn må kan ikke vøre tomt") @Size(min = 2, max = 12, message = "etternavn må vøre minst 2 tegen og max 12 tegn") @Pattern(regexp = "^[A-ZÆØÅa-zæøå-]$") String etternavn,
			@Past @NotNull(message = "fodelsdato må kan ikke vøre tomt") LocalDate fodelsdato,
			@Pattern(regexp = "^[MK]$", message = "Kjønn må være enten 'M' eller 'K'") char kjonn,
			@Min(value = 2020, message = "startDato må vøre minst 2020") LocalDate startDato,
			@Pattern(regexp = "SJEF|UTVIKLER|ØKONOM", message = "Ugyldig stilling. Tillatte verdier: Sjef, Utvikler, Økonom") Stilling stilling,
			@Min(value = 10000, message = "maanedsLonn må være minst 10000") @Max(value = 200000, message = "maanedsLonn må være max 200000") Integer maanedsLonn) {
		super();
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.fodelsdato = fodelsdato;
		this.kjonn = kjonn;
		this.startDato = startDato;
		this.stilling = stilling;
		this.maanedsLonn = maanedsLonn;
	}

	
	
	
}
