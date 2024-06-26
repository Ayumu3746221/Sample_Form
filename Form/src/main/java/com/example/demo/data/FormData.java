package com.example.demo.data;


import com.example.demo.entity.Form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FormData {
	
	private Integer id;
	
	@NotBlank(message = "お名前を入力して下さい")
	private String name;
	
	@NotNull(message = "ご年齢を入力してください")
	private Integer age;
	
	@NotBlank(message = "メールアドレスを入力して下さい")
	private String email;
	
	@NotNull(message = "どれかを必ず選択して下さい")
	private Integer gender;
	
	@NotBlank(message = "内容をお書き下さい")
	private String content;
	
	public Form toEntity() {
		Form form = new Form();
		
		form.setId(id);
		form.setName(name);
		form.setAge(age);
		form.setEmail(email);
		form.setEmail(email);
		form.setContent(content);
		
		return form;
	}
}
