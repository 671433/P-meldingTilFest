package com.hvl.no.Oblig4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hvl.no.Oblig4.model.Deltager;
import com.hvl.no.Oblig4.service.DeltagerService;
import com.hvl.no.Oblig4.service.PassordService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/innlogging")
public class InnloggingController {
	
	@Autowired
	private DeltagerService deltagerService;
	
	@Autowired
	private PassordService passordService;
	
	
	@GetMapping
	public String visInnloggingSide() {
		
		return"innlogging";
		
	}
	
	@PostMapping
	public String loggInn (@RequestParam String mobil, @RequestParam String passord,
			HttpServletRequest request, RedirectAttributes ra ,HttpSession session) {
		
	
		
		Deltager deltager = deltagerService.hentDeltager(mobil);
		
		if(deltager == null) {
			ra.addFlashAttribute("error_message", "Denne konto finns ikke, prøv igjen med riktig mobil og passord");
			return"redirect:innlogging";
		}
		
		if(!passordService.erKorrektPassord(passord, deltager.getSalt(), deltager.getHash())) {
			ra.addFlashAttribute("error_message", "Brukernavn(mobil) eller passord er feil");
			return"redirect:innlogging";
		}
		session.setAttribute("mobil", mobil);
		session.setAttribute("erBrukerInnlogget",true);
		return "redirect:deltagerliste";
		
	}
	


}
