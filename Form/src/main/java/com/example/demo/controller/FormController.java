package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormController {
	@GetMapping("/")
	public String Home() {
		return "Home";
	}
	
	@GetMapping("/form")
	public String form() {
		return "form";
	}
}
