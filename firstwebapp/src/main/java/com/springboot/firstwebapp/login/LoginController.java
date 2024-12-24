package com.springboot.firstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
		
	//Get
	@RequestMapping(value="login",method = RequestMethod.GET)
	public String GoToLoginPage() {
		return "login";
	}
	
	//Post ,when submit button is clicked,it handles the post request as in the html(jsp),from method is post 
	@RequestMapping(value="login",method = RequestMethod.POST)
	public String GoToWelcomePage(@RequestParam("NAME") String name,@RequestParam("PASSWORD") String password,
				ModelMap model) {
		model.put("NAME",name);
		model.put("PASSWORD",password);
		return "Welcome";
	}
	
}
