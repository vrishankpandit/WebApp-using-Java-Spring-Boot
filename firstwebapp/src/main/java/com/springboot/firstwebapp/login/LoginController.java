package com.springboot.firstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	private Logger logger=LoggerFactory.getLogger(getClass());
	
//	http://localhost:8081/login?name=vp
//	Model
	@RequestMapping("login")
	public String GoToLoginPage(@RequestParam String name,ModelMap model) {
//		System.out.println(name);
		logger.debug("name is {}",name);
		logger.info("print at info level");
		logger.warn("print at warn level");
		
		model.put("name", name);
		return "login";
	}
}
