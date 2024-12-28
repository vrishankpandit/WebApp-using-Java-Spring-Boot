package com.springboot.firstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

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
	public String addNewTodo(ModelMap model,@Valid Todo todo,BindingResult result) {
		
		if(result.hasErrors())
			return "todo";
			
		
		String username=(String)model.get("name");
		todoService.addTodo(username, todo.getDescription(), todo.getTargetDate().plusYears(1), false);
		
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteTodo(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo",method=RequestMethod.GET)
	public String update(@RequestParam int id,ModelMap model) {
		Todo todo=todoService.findById(id);
		model.addAttribute(todo);
//		todoService.deleteTodo(id);
		
		return "todo";
	}
	
	@RequestMapping(value="update-todo",method=RequestMethod.POST)
	public String updateByDe(ModelMap model,@Valid Todo todo,BindingResult result) {
		if(result.hasErrors())
			return "todo";
			
		
		String username=(String)model.get("name");
		todo.setName(username);
		todoService.updateTodo(todo);
		
		return "redirect:list-todos";
	}
}
