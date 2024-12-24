package com.springboot.firstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
//	http://localhost:8081/login?name=vp
//	Model
	@RequestMapping("login")
	public String GoToLoginPage(@RequestParam String name,ModelMap model) {
//		System.out.println(name);
		model.put("name", name);
		return "login";
	}
}
