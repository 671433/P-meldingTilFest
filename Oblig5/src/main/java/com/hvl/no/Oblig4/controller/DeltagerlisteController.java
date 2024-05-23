package com.hvl.no.Oblig4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hvl.no.Oblig4.service.DeltagerService;
import com.hvl.no.Oblig4.util.LoginUtil2;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/deltagerliste")
public class DeltagerlisteController {
	
	@Autowired
	private DeltagerService deltagerService;
	
	@GetMapping
	public String visDeltagerListe(HttpServletRequest request, ModelMap model, RedirectAttributes ra) {
		
		if(!LoginUtil2.erBrukerInnlogget(request.getSession())) {
			ra.addFlashAttribute("error_message", "Du må logge deg in for å gå videre");
			return"redirect:innlogging";
		}
		
		model.addAttribute("deltagere", deltagerService.hentAllDeltagere());
		model.addAttribute("aktulig", 
				deltagerService.hentDeltager(request.getSession().getAttribute("mobil").toString()));
		
		return"deltagerliste";
		
	}
	
	

}
