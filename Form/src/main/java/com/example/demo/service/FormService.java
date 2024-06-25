package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.example.demo.data.FormData;

@Service
public class FormService {
	//Validationでチェック仕切れないところをカバー
	public boolean isValid(FormData formData,BindingResult result) {
		
		boolean ans = true;
		
		//名前が全角スペースだけで構成されていたらエラーを返す
		String name = formData.getName();
		if(name !=null && !name.equals("")) {
			boolean isAllDoubleSpace = true;
			for (int i = 0; i < name.length(); i++) {	
				if (name.charAt(i) !='　') {
					isAllDoubleSpace = false;
					break;
				}
			}
			if (isAllDoubleSpace) {
				FieldError fieldError = new FieldError(result.getObjectName(),"name","全角スペースのみは禁止です");
				result.addError(fieldError);
				ans = false;
			}
		}
		
		//年齢が18歳未満だったらエラー
		Integer age = formData.getAge();
		if (age == null) {
			ans = false; //nullの場合はValidationチェックでカバーできる
		}
		else if (age < 18) {
			boolean isAgeTooYang = true;
			if (isAgeTooYang) {
				FieldError fieldError = new FieldError(result.getObjectName(), "age", "大人の方に相談して下さい");
				result.addError(fieldError);
				ans = false;
			}
		}
		
		return ans;	
		}
	}

