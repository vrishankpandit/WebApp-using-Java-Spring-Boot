package com.springboot.firstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
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
