package com.springboot.firstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String showNewTodoPage(ModelMap model) {
		String username=(String)model.get("name");
		Todo todo=new Todo(0,username,"",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="add-todo",method=RequestMethod.POST)
	public String addNewTodo(ModelMap model,Todo todo) {
		String username=(String)model.get("name");
		todoService.addTodo(username, todo.getDescription(), LocalDate.now().plusYears(1), false);
		
		return "redirect:list-todos";
	}
}
