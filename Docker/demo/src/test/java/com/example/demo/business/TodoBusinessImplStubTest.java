/*package com.example.demo.business;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.example.demo.TodoServiceStub;
import com.example.demo.repository.ToDoService;

public class TodoBusinessImplStubTest {

	@Test
	public void testretrivesTodosRelatedToSpring_usingAStub() {
		ToDoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = 
				new TodoBusinessImpl(todoServiceStub);
		List<String> filteredToDos = todoBusinessImpl.retrivesTodosRelatedToSpring("dummy");
		assertEquals(2, filteredToDos.size());
	}

}
*/