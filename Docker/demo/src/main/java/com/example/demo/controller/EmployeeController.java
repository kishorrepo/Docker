package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.responseMessage.Response;
import com.example.demo.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping(value="/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	
	@SuppressWarnings("rawtypes")
	//@CrossOrigin(value="http://localhost:4200")
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public ResponseEntity saveEmployee(@RequestBody Employee emp){
		System.out.println("Inside saveEmployee: "+emp.toString());
		
		 Response resp = employeeService.saveEmployee(emp);
		
		return new ResponseEntity<Response>(resp,HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	//@CrossOrigin(value="http://localhost:4200")
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	public ResponseEntity<List> getEmployeeList(){
		List<Employee> empList = employeeService.getEmployeeList();
		return new ResponseEntity<List>(empList,HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	//@CrossOrigin(value="http://localhost:4200")
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ResponseEntity updateEmployee(@RequestBody Employee emp){
		Response resp = employeeService.updateEmployee(emp);
		return new ResponseEntity<Response>(resp,HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	//@CrossOrigin(value="http://localhost:4200")
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public ResponseEntity deleteEmployee(@RequestBody Employee emp ){
		Response resp = employeeService.deleteEmployee(emp.getEmployeeId());
		return new ResponseEntity<Response>(resp,HttpStatus.OK);
	}
	
	@GetMapping("/createEmployee")
	public List<Employee>  createEmployee(){
		Employee emp = new Employee();
		
		emp.setEmpCode("QH001");
		emp.setFirstName("Test_First_Name");
		emp.setLastName("Test_Last_Name");
		emp.setOffice("Shivaginagar");
		emp.setPosition("QA");
		
		Response resp = employeeService.saveEmployee(emp);
		
		System.out.println("Response : "+resp);
		
		List<Employee> empList = employeeService.getEmployeeList();
		
		return empList;
	}
}
