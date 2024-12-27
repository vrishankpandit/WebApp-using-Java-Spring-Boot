package com.springboot.firstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	private static int todoCount=0;
	
	static {
		todos.add(new Todo(++todoCount,"LearnCourse","AWS",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todoCount,"LearnCourse","Docker",LocalDate.now().plusYears(2),false));
		todos.add(new Todo(++todoCount,"LearnCourse","AI",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todoCount,"LearnCourse","SPRING",LocalDate.now().plusYears(2),false));
		
	}
	
	public List<Todo> findByUsername(String Username){
		return todos; 
	}
	
	public void addTodo(String name, String description, LocalDate targetDate, boolean done) {
		Todo todo=new Todo(++todoCount,name, description, targetDate, done);
		todos.add(todo);
	}
}
