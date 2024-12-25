package com.springboot.firstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

public class TodoService {
	private static List<Todo> todos;
	static {
		todos.add(new Todo(1,"LearnCourse","AWS",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(2,"LearnCourse","Docker",LocalDate.now().plusYears(2),false));
		todos.add(new Todo(3,"LearnCourse","AI",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(4,"LearnCourse","SPRING",LocalDate.now().plusYears(2),false));
		
	}
	
	public List<Todo> findByUsername(String Username){
		return todos;
	}
}
