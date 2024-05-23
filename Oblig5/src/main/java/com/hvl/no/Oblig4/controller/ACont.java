package com.hvl.no.Oblig4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hvl.no.firma.Ansatt;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/reg")
public class ACont {
	
	@GetMapping
	public String hentkjema() {
		return "registerAnsatt";
	}
	
	@PostMapping
	public String tarSkjma(
			@Valid @ModelAttribute("ansatt")Ansatt ansatt ,
			Model model , BindingResult bindingResult, RedirectAttributes ra
			) {
		
		if(bindingResult.hasErrors()) {
			String feilmelding = bindingResult.getAllErrors().stream()
					.map(e -> e.getDefaultMessage())
					.reduce("",(s, e)-> s +e + "<br>");
			
			model.addAttribute("feilmelding", feilmelding);
			
			return "registerAnsatt";
		}
		
		Ansatt ny = new Ansatt(ansatt.getFornavn(),
				ansatt.getEtternavn(), 
				ansatt.getFodelsdato(), ansatt.getKjonn(), ansatt.getStartDato(),
				ansatt.getStilling(), ansatt.getMaanedsLonn());
		
		ra.addAttribute("fornavn", ny.getFornavn());
		ra.addAttribute("etternavn", ny.getEtternavn());
		ra.addAttribute("fodelsdato", ny.getFodelsdato());
		ra.addAttribute("kjonn", ny.getKjonn());
		ra.addAttribute("startDato", ny.getStartDato());
		ra.addAttribute("stilling", ny.getStilling());
		ra.addAttribute("maanedslonn", ny.getMaanedsLonn());
		
		return "redirect:aview";
		
	}
	

}
