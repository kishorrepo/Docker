package com.example.demo.business;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.repository.ToDoService;
//STUB
//ToDoService Dependency
public class TodoBusinessImpl {

	private ToDoService toDoService;

	public TodoBusinessImpl(ToDoService toDoService) {
		super();
		this.toDoService = toDoService;
	}
	
	public List<String> retrivesTodosRelatedToSpring(String user){
		List<String> filteredToDos = new ArrayList<String>();
		List<String> toDos = toDoService.retriveTodos(user);
		for(String toDo : toDos){
			if(toDo.contains("Spring")){
				filteredToDos.add(toDo);
			}
		}
		return filteredToDos;
		
	}
}
