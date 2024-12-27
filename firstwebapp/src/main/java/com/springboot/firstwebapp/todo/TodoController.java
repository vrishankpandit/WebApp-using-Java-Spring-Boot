package com.springboot.firstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping(value="add-todo",method=RequestMethod.GET)
	public String showNewTodoPage() {
		return "todo";
	}
	
	@RequestMapping(value="add-todo",method=RequestMethod.POST)
	public String addNewTodo(@RequestParam String description,ModelMap model) {
		String username=(String)model.get("NAME");
		todoService.addTodo(username, description, LocalDate.now().plusYears(1), false);
		
		return "redirect:list-todos";
	}
}
