package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GeneratorType;


@Entity
@Table(name="Employee")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int employeeId;
	
	@Column(name="firstName",nullable=false,length=25)
	private String firstName;
	
	@Column(name="lastName",nullable=false,length=25)
	private String lastName;
	
	@Column(name="position",nullable=false,length=50)
	private String position;
	
	@Column(name="empCode",nullable=false,length=15)
	private String empCode;
	
	@Column(name="office",nullable=false,length=255)
	private String office;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", position=" + position + ", empCode=" + empCode + ", office=" + office + "]";
	}
	public Employee() {
		super();
		
	}

}
