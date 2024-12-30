package com.springboot.firstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("NAME")
public class WelcomeController {
	
//	private AuthenticationService authenticationService;
//		
//	public LoginController(AuthenticationService authenticationService) {
//		super();
//		this.authenticationService = authenticationService;
//	}

	//Get
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String GoToWelcomePage(ModelMap model) {		
		model.put("NAME",getLoginUsername());
		return "Welcome";
	}
	
	private String getLoginUsername() {
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}
	
//	//Post ,when submit button is clicked,it handles the post request as in the html(jsp),from method is post 
//	@RequestMapping(value="login",method = RequestMethod.POST)
//	public String GoToWelcomePage(@RequestParam("NAME") String name,@RequestParam("PASSWORD") String password,
//				ModelMap model) {
//		if(authenticationService.auth(name, password)) {
//			
//			model.put("NAME",name);
////			model.put("PASSWORD",password);
//			return "Welcome";
//		}
//		
//		model.put("errorMessage","Invalid Credentials please try again !!!");
//		return "login";
//	}
	
}
