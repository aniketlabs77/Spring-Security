package com.aniket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication; 

@Controller
public class MyController {

	
	@GetMapping("/")
	public String home() {
		return "index" ; 
	}
	
	@GetMapping("/applogin")
	public String login() {
		return "applogin" ; 
	}
	
	@GetMapping("/demo1")
	public String demo1(Authentication auth, HttpSession session, ModelMap m) {
		m.addAttribute("username", auth.getName()); 
		session.setAttribute("cname", "Aniket"); 
		return "demo1" ; 
	}
	
	
	@GetMapping("/demo2")
	public String demo2(Authentication auth, ModelMap m) {
		m.addAttribute("username", auth.getName()); 
		return "demo2" ; 
	}
	
	@GetMapping("/demo3")
	public String demo3(Authentication auth, ModelMap m) {
		m.addAttribute("username", auth.getName()); 
		return "demo3" ; 
	}
	
	@GetMapping("/demo4")
	public String demo4(Authentication auth, ModelMap m) {
		m.addAttribute("username", auth.getName()); 
		return "demo4" ; 
	}
	
	@GetMapping("/accessDenied")
	public String accessDenied() {
		return "accessDenied" ; 
	}
	
}
