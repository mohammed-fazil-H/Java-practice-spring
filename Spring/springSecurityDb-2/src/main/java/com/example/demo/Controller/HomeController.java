package com.example.demo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class HomeController
{
	@GetMapping("/public")
	public ResponseEntity<String> publicUser(){
		
		return ResponseEntity.ok("I am public ");
	}
	
	@GetMapping("/admin")
	public ResponseEntity<String> adminUser(){
		
		return ResponseEntity.ok("I am admin ");
	}
	
	


}
