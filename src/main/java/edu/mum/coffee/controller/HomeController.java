package edu.mum.coffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping({"/", "/index", "/home"})
	public String homePage() {
		return "home";
	}

	@GetMapping({"/secure"})
	public String securePage() {
		return "secure";
	}
	
	@GetMapping("/products")
	public String products(){
		return "products";
	}
	
	@GetMapping("/product")
	public String product(){
		return "addproduct";
	}
	
	@GetMapping("/order")
	public String order(){
		return "order";
	}
	
	@GetMapping("/users")
	public String users(){
		return "users";
	}
	@GetMapping("/profile")
	public String profile(){
		return "profile";
	}
	
	@GetMapping("/success")
	public String success(){
		return "redirect:/success";
	}
	
	@GetMapping("/signup")
	public String signup(){
		return "signup";
	}
	
	@GetMapping("/403")
	public String anauthorized(){
		return "403";
	}
}
