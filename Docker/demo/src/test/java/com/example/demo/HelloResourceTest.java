/*package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.HelloController;

@RunWith(SpringJUnit4ClassRunner.class)
public class HelloResourceTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	private HelloController helloController;
	
	@Before
	public void setUp() throws Exception{
		mockMvc = MockMvcBuilders.standaloneSetup(helloController)
				.build(); 
	}
	
	@Test
	public void testHello() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/api/hello"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("hello world"));
	}
}
*/