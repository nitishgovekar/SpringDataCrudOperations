package com.springdata.jpqlandnativesql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springdata.jpqlandnativesql.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{
	
	//if you want all records no need provide select just provide Domain class name
	@Query("from Student")
	List<Student> findAllStudents();
	
	@Query("select st.firstName,st.lastName from Student st ")
	List<Object[]> findAllStudentPartialData();

}
