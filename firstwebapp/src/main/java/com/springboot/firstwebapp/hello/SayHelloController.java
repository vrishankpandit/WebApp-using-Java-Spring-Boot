package com.springboot.firstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@RestController
@Controller
public class SayHelloController {

	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Helllo what u doing:";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb=new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("	<title>  My First Page </title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<h1> HALLLO </h1>");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
	}
	
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayhello";
	}
	
}
