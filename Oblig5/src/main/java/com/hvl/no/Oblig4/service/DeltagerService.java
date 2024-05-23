package com.hvl.no.Oblig4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvl.no.Oblig4.Repository.DeltagerRepository;
import com.hvl.no.Oblig4.model.Deltager;


@Service
public class DeltagerService {
	
	@Autowired
	private DeltagerRepository deltagerRepository;
	
	@Autowired
	private PassordService passordService;

	public boolean oppretteDeltaker (String mobil, String fornavn, String etternavn,
			String hash, String salt,String kjonn) {
		
		//if(salt == null) {
			salt = passordService.genererTilfeldigSalt();
		//}
		
		String hashOgSalt = passordService.hashMedSalt(hash, salt);
		
		
		if (deltagerRepository.findByMobil(mobil) != null) {
			return false;
		}
		 
		deltagerRepository.save(new Deltager(mobil, fornavn, etternavn, hashOgSalt,salt, kjonn));
		return true;
		
	}
	
	public Deltager hentDeltager(String mobil) {
		return deltagerRepository.findByMobil(mobil);
	}
	
	public List<Deltager>hentAllDeltagere(){
		return deltagerRepository.findAllByOrderByFornavnAscEtternavnAsc();
	}
	
}
