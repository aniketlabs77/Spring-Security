package com.aniket.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {

	
	@GetMapping("/")
	public String home() {
		return "index" ; 
	}
	
	
	@GetMapping("/demo1")
	public String demo1(org.springframework.security.core.Authentication auth, HttpSession session, ModelMap m) {
		m.addAttribute("username", auth.getName()); 
		session.setAttribute("cname", "Aniket"); 
		return "demo1" ; 
	}
	
	
	@GetMapping("/demo2")
	public String demo2(Authentication auth, ModelMap m) {
		m.addAttribute("username", auth.name()); 
		return "demo2" ; 
	}
	
	@GetMapping("/demo3")
	public String demo3(Authentication auth, ModelMap m) {
		m.addAttribute("username", auth.name());  
		return "demo3" ; 
	}
	
	@GetMapping("/accessDenied")
	public String accessDenied() {
		return "accessDenied" ; 
	}
	
}
