package com.hvl.no.Oblig4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.hvl.no.Oblig4.Repository.DeltagerRepository;
import com.hvl.no.Oblig4.model.Deltager;
import com.hvl.no.Oblig4.service.DeltagerService;


@ExtendWith(MockitoExtension.class) 
public class DeltagerServiceTest {
	
	@Mock
	DeltagerRepository mockRepo;
	
	@InjectMocks
	DeltagerService deltagerService;
	
	@Test
	void findAllByOrderByFornavnAscEtternavnAscTest() {
		
		when(mockRepo.findAllByOrderByFornavnAscEtternavnAsc()).thenReturn(List.of(
				new Deltager("22222222","Anne","Annesen","1234","1234","Kivnne"),
				new Deltager("00000000","Bil","larsen","1234","1234","mann"),
				new Deltager("11111111","Tamer","Deen","1234","1234","mann"),
				new Deltager("33333333","Per","Persen","5555","1234","mann"),
				new Deltager("44444444","Sanne","Sassen","1234","1234","Kivnne")
				
				));
		
		
		List<Deltager> resultat = deltagerService.hentAllDeltagere();
		
		assertEquals(5,resultat.size());
		assertTrue(resultat.get(0).getFornavn()=="Anne");
		assertTrue(resultat.get(1).getEtternavn()=="larsen");
		assertTrue(resultat.get(2).getMobil()=="11111111");
		assertTrue(resultat.get(3).getHash()=="5555");
		assertTrue(resultat.get(4).getKjonn()=="Kivnne");
		assertFalse(resultat.get(0).getFornavn()=="Tamer");
		assertFalse(resultat.get(1).getEtternavn()=="Deen");
		assertFalse(resultat.get(2).getMobil()=="99999999");
		assertFalse(resultat.get(3).getHash()=="1234");
		assertFalse(resultat.get(4).getKjonn()=="mann");


		
		
	}
	
	@Test
	void henteVedMobilTest() {
		
		when(mockRepo.findByMobil("00112233")).thenReturn(
				new Deltager("00112233","Tamer","Deen","1234","1234","mann")
				);
		
		Deltager d = deltagerService.hentDeltager("00112233");
		
		assertEquals(d.getMobil(), "00112233");
	}
	
	
	

}
