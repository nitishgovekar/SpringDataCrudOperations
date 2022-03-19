package com.springdata.idgenerators.repository;

import org.springframework.data.repository.CrudRepository;

import com.springdata.idgenerators.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

	
}
