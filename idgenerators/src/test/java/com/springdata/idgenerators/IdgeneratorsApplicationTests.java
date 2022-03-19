package com.springdata.idgenerators;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springdata.idgenerators.entity.Employee;
import com.springdata.idgenerators.repository.EmployeeRepository;

@SpringBootTest
class IdgeneratorsApplicationTests {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Test
	void testCreateEmployee() {
		Employee emp = new Employee();
		emp.setName("Nitish");
		employeeRepository.save(emp);
	}

}
