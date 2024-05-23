package com.hvl.no.Oblig4;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import com.hvl.no.Oblig4.model.Deltager;

import jakarta.validation.Validation;
import jakarta.validation.Validator;


@SpringBootTest
class Oblig4ApplicationTests {
	
	
	private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	@Test
	public void erGyldigAlleEgenskapTest() {

		Deltager deltager = new Deltager("11111111","Tamer","Deen","1234","1234","mann");
		
		assertTrue(erGyldigEgenskap(deltager, "mobil"));
		assertTrue(erGyldigEgenskap(deltager, "fornavn"));
		assertTrue(erGyldigEgenskap(deltager, "etternavn"));
		assertTrue(erGyldigEgenskap(deltager, "hash"));
		assertTrue(erGyldigEgenskap(deltager, "salt"));
		assertTrue(erGyldigEgenskap(deltager, "mann"));
		
	}
	
	@ParameterizedTest
	@ValueSource(strings ={"","a","/ab","tamer","tamer*deen","TamerDeen"})
	public void uGyldigFornavn(String navnFraListe) {
		
		Deltager deltager = new Deltager("11111111",navnFraListe,"Deen","1234","1234","mann");
		
		assertFalse(erGyldigEgenskap(deltager, "fornavn"));
		
	}

	@ParameterizedTest
	@ValueSource(strings ={"","a","/ab","tamer","tamer*deen","Tamer Deen"})
	public void uGyldigEtternavn(String navnFraListe) {
		
		Deltager deltager = new Deltager("11111111","Tamer",navnFraListe,"1234","1234","mann");
		
		assertFalse(erGyldigEgenskap(deltager, "etternavn"));
		
	}

	@ParameterizedTest
	@ValueSource(strings ={"Ab","Tamer","Tamer-deen"})
	public void gyldigEtternavn(String navnFraListe) {
		
		Deltager deltager = new Deltager("11111111","Tamer",navnFraListe,"1234","1234","mann");
		
		assertTrue(erGyldigEgenskap(deltager, "etternavn"));
		
	}
	
	@ParameterizedTest
	@ValueSource(strings ={"Ab","Tamer","Tamer-deen","Tamer deen"})
	public void gyldigFornavn(String navnFraListe) {
		
		Deltager deltager = new Deltager("11111111",navnFraListe,"Deen","1234","1234","mann");
		
		assertTrue(erGyldigEgenskap(deltager, "fornavn"));
		
	}

	
	
	
	
	
	/***********************************************************************/
	
	/* 
	 * Hjelpemetode til bruk i testingen.
	 * Sjekker feltet med navn feltnavn er gyldig for person.
	 */
	private boolean erGyldigEgenskap(Deltager deltager, String egenskap) {
		
		return !validator.validate(deltager).stream()			//Strøm av alle feil (objekter)
				.map(v -> v.getPropertyPath().toString())	//Strøm av alle egenskaper med feil
				.collect(Collectors.toSet())				//Samlet opp i et Set av egenskaper med feil
				.contains(egenskap);						//Om den egenskapen vi lurer på har feil
	}
}
