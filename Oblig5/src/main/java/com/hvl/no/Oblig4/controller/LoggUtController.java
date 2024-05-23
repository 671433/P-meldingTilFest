package com.hvl.no.Oblig4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hvl.no.Oblig4.util.LoginUtil2;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/utlogging" )
public class LoggUtController {
	
	@GetMapping
	public String visLoggUt() {
		return "innlogging";
	}
	
	
	@PostMapping
	public String loggUt (HttpServletRequest request, RedirectAttributes ra) {
		LoginUtil2.loggUtBruker(request.getSession());
		ra.addFlashAttribute("beskjed_message", "Du er logget ut");
		return "redirect:innlogging";
	}
	
	

}
