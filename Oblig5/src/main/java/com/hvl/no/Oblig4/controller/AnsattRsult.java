package com.hvl.no.Oblig4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aview")
public class AnsattRsult {
	
	
	@GetMapping
	public String getSide() {
		return"aview";
	}
	

}
