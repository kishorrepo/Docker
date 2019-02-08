package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.responseMessage.Response;
@RestController
@RequestMapping(value="/api")
public class HelloController {

	
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String  hello(){
		  return "hello world";
		
	}
	
	@RequestMapping(value="/getUser",method=RequestMethod.GET)
	public ResponseEntity<User> getUser(){
		User user = new User();
		user.setId(1);
		user.setName("ABC");
		user.setMobPhone("1111111111");
		user.setAge(25);
		
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	
	/*@RequestMapping(value="/saveUser",method=RequestMethod.POST)
	public ResponseEntity<Response> saveUser(@RequestBody User user){
		
		System.out.println("Inside saveUser : "+user.toString());
		Response response=userService.saveUser(user);
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}*/
}
