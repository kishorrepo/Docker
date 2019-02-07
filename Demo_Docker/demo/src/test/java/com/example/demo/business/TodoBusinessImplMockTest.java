/*package com.example.demo.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.Test;

import com.example.demo.TodoServiceStub;
import com.example.demo.repository.ToDoService;

public class TodoBusinessImplMockTest {

	@Test
	public void testretrivesTodosRelatedToSpring_usingAMock() {
		ToDoService todoServiceMock = mock(ToDoService.class);
		
		//when(todoServiceMock.retriveTodos("Dummy")).
		
		ToDoService toDos = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = 
				new TodoBusinessImpl(todoServiceMock);
		List<String> filteredToDos = todoBusinessImpl.retrivesTodosRelatedToSpring("dummy");
		assertEquals(2, filteredToDos.size());
	}
}
*/