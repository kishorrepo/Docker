/*package com.example.demo.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Employee;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class EmployeeRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	public void testSaveEmployee(){
		Employee emp = getEmployee();
		Employee  saveEmpInDb = employeeRepository.save(emp);
		System.out.println("saveEmpInDb : "+saveEmpInDb.toString());
		Optional<Employee> getFromDB = employeeRepository.findById(saveEmpInDb.getEmployeeId());
		
		System.out.println("getFromDB : "+getFromDB.toString());
		 assertTrue(getFromDB.isPresent());
		 getFromDB = Optional.ofNullable(null);
		 assertFalse(getFromDB.isPresent());
		 
		 
		
		//assertThat(getFromDB).isEqualTo(saveEmpInDb);
	}
	
	private Employee getEmployee(){
		Employee emp = new Employee();
		emp.setEmpCode("QH-001");
		emp.setFirstName("ABC");
		emp.setLastName("PQR");
		emp.setOffice("Quick Heal");
		emp.setPosition("SE");
		return emp;
	}
}
*/