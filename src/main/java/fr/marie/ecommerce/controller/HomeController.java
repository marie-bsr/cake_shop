package fr.marie.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
	
	
	
	@GetMapping("/bonjour")
	public String printBonjour() {
	return "Ici on dit bonjour";
	}
	
	@GetMapping("/")
	public String index() {
	System.out.println("/ : Home page");
	return "home";
	}
	
	

}
