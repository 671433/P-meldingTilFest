package com.hvl.no.Oblig4.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginUtil2 {
	
	public static void loggUtBruker(HttpSession session) {
		
		session.invalidate();
	}

	public static void loggInnBruker(HttpServletRequest request, String mobil) {
		
		// trenger ny sesjon etter man logg ut 
		loggUtBruker(request.getSession());
		
		// trenger ny session og data 
		HttpSession sesjon = request.getSession();
		sesjon.setMaxInactiveInterval(120); // 120 sekunder
		
		sesjon.setAttribute("mobil", mobil);
		sesjon.setAttribute("erBrukerInnlogget",true);
		
	}
	
	public static boolean erBrukerInnlogget(HttpSession session) {
		
		return session !=null && session.getAttribute("mobil") !=null;
				
	}

}
