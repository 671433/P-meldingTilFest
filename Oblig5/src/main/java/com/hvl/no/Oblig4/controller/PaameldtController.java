package com.hvl.no.Oblig4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hvl.no.Oblig4.util.LoginUtil2;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/paameldt")
public class PaameldtController {
	
	@GetMapping
	public String visPaameldtSide(HttpSession session, RedirectAttributes ra) {
		
		if (!LoginUtil2.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("error_message", "Logg in innlogging side");
			return "redirect:innlogging";
		}
		
		return "paameldt";
		
	}

}
