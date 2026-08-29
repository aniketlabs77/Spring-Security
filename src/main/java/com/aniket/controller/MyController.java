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
	public String demo1(Authentication auth, HttpSession session, ModelMap m) {
		m.addAttribute("userName", auth.name()); 
		session.setAttribute("cname", "Aniket"); 
		return "demo1" ; 
	}
	
	
	@GetMapping("/demo2")
	public String demo2(Authentication auth, ModelMap m) {
		m.addAttribute("userName", auth.name()); 
		return "demo1" ; 
	}
	
	@GetMapping("/demo3")
	public String demo3(Authentication auth, ModelMap m) {
		m.addAttribute("userName", auth.name());  
		return "demo1" ; 
	}
	
	@GetMapping("/accessDenied")
	public String accessDenied() {
		return "accessDenied" ; 
	}
	
}
