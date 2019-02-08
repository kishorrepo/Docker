package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.responseMessage.Response;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	
	public Response saveEmployee(Employee emp){
		Response resp = new Response();
		Employee e = employeeRepository.save(emp);
		if(e!=null){
			resp.setMessage("Employee created successfully");
		}
		else{
			resp.setMessage("Error in employee creation");
		}
		return resp;
	}
	
	public List<Employee> getEmployeeList(){
		return (List<Employee>) employeeRepository.findAll();
	}
	
	public Response updateEmployee(Employee emp){
		Response resp = new Response();
		Employee e = employeeRepository.save(emp);
		if(e!=null){
			resp.setMessage("Employee updated successfully");
		}
		else{
			resp.setMessage("Error in employee updation");
		}
		return resp;
	}
	
	public Response deleteEmployee(int empId){
		Response resp = new Response();
		 employeeRepository.delete(empId);
		 resp.setMessage("Employee deleted successfully");
		 return resp;

	}
}
