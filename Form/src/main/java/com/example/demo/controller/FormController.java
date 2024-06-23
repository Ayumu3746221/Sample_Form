package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.data.FormData;

import org.springframework.ui.Model;

@Controller
public class FormController {
	@GetMapping("/")
	public String Home() {
		return "Home";
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("formData",new FormData());
		return "form";
	}
	
	@PostMapping("/confirmation")
	public ModelAndView toForm(@ModelAttribute FormData formData, ModelAndView mv) {
		mv.setViewName("confirmation");
		mv.addObject("formData", formData);
		return mv;
	}
	
	@PostMapping("/cancel")
	public String calcelForm() {
		return "Home";
	}
}
