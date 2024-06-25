package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.data.FormData;
import com.example.demo.service.FormService;

import lombok.AllArgsConstructor;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@Controller
@AllArgsConstructor
public class FormController {
	private final FormService formService;
	
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
	public ModelAndView toForm(@ModelAttribute @Validated FormData formData,BindingResult bindingResult,ModelAndView mv) {
		
		//サービスクラスによるエラーチェック
		boolean isValid = formService.isValid(formData, bindingResult);
		
		//エラーチェックテスト用
		System.out.println(bindingResult);
		System.out.println(formData);
		
		if (!bindingResult.hasErrors() && isValid) {
			//エラーなし
			mv.setViewName("confirmation");
			mv.addObject("formData", formData);
		}else {
			//エラーあり
			mv.setViewName("Form");
		}
		return mv;
	}
	
	@PostMapping("/cancel")
	public String calcelForm() {
		return "Home";
	}
}
