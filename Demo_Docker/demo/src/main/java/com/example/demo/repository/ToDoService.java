package com.example.demo.repository;

import java.util.List;

//Create todoServiceStub
public interface ToDoService {
	public List<String> retriveTodos(String user);
	public List<String>configureSomething(String user);

}
