package com.springboot.firstwebapp.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoController {
	
	private TodoService todoService;

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}


	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		
		List<Todo> todos=todoService.findByUsername("Docker");
		model.addAttribute("todos", todos);  //(firstname is mapped to the attribute in html,whereas second name is local variable)
		return "ListTodos";
		
	}
}
