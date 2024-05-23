package com.hvl.no.Oblig4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hvl.no.Oblig4.model.Deltager;
import com.hvl.no.Oblig4.service.DeltagerService;
import com.hvl.no.Oblig4.util.LoginUtil2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/paamelding")
public class PaameldingController {
	
	@Autowired
	private DeltagerService deltagerService;
	
	@GetMapping
	public String hentLoginSkjema() {
		return "paamelding";
	}
	
	
	@PostMapping
	public String paamelding(@Valid @ModelAttribute("deltager") Deltager deltager,
			BindingResult bindingResult, Model model, HttpServletRequest request,
	        RedirectAttributes ra) {
		
		if(bindingResult.hasErrors()) {
			String feilmeldinger = bindingResult.getAllErrors().stream()
					.map(e->e.getDefaultMessage())
					.reduce("",(s,e)-> s + e +"<br>");
		
			model.addAttribute("feilmeldinger", feilmeldinger);
			
			System.out.println(feilmeldinger);
			
			return "paamelding";
			
			
		}
		
//		if (deltager.getHash() != deltager.getSalt()) {
//			ra.addFlashAttribute("error_message", "Passord og Passord repetert må være det samme");
//			return "redirect:paamelding";
//		}

		
		// oppertter ny deltager i databasse
		boolean lageDeltaker = deltagerService.oppretteDeltaker(
				deltager.getMobil(), deltager.getFornavn(),deltager.getEtternavn(), 
				deltager.getHash(), deltager.getSalt(), deltager.getKjonn());
		
		// hvis det ikke opperttet ny deltager
		if (!lageDeltaker) {
			ra.addFlashAttribute("error2_message", "Kunne ikke registrere deltakelse, telefonnummer er allerede i bruk");
			return "redirect:paamelding";
		}
		
		// hvis det deltager lagt riktig , må logg in automatisk
		Deltager deltagerSomLagt = deltagerService.hentDeltager(deltager.getMobil());
		LoginUtil2.loggInnBruker(request, deltagerSomLagt.getMobil());
		
		ra.addFlashAttribute("fornavn", deltagerSomLagt.getFornavn());
		ra.addFlashAttribute("etternavn", deltagerSomLagt.getEtternavn());
		ra.addFlashAttribute("mobil", deltagerSomLagt.getMobil());
		ra.addFlashAttribute("kjonn", deltagerSomLagt.getKjonn());
		
		return "redirect:paameldt";
	}
	
	

}
