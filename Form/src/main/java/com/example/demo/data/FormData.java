package com.example.demo.data;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FormData {
	
	private Integer idInteger;
	
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
}
