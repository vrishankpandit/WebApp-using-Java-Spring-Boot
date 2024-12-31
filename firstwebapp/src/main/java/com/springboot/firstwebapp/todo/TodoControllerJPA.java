package com.springboot.firstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("NAME")
public class TodoControllerJPA {
	
	private TodoService todoService;
	private TodoRepository todoRepository;
	
	public TodoControllerJPA(TodoService todoService,TodoRepository todoRepository) {
		super();
		this.todoService = todoService;
		this.todoRepository=todoRepository;
	}


	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String username=getLoggedInUsername(model);		
		List<Todo> todos=todoRepository.findByName(username);
		model.addAttribute("todos", todos);  //(firstname is mapped to the attribute in html,whereas second name is local variable)
		return "ListTodos";
		
	}
	
	@RequestMapping(value="add-todo",method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username=getLoggedInUsername(model);
		Todo todo=new Todo(0,username,"",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="add-todo",method=RequestMethod.POST)
	public String addNewTodo(ModelMap model,@Valid Todo todo,BindingResult result) {
		
		if(result.hasErrors())
			return "todo";
			
		
		String username=getLoggedInUsername(model);
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
			
		
		String username=getLoggedInUsername(model);
		todo.setName(username);
		todoService.updateTodo(todo);
		
		return "redirect:list-todos";
	}


	private String getLoggedInUsername(ModelMap model) {
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}
}
