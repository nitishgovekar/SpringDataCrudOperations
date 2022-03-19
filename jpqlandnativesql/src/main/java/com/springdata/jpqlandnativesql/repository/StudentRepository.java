package com.springdata.jpqlandnativesql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springdata.jpqlandnativesql.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{
	
	//if you want all records no need provide select just provide Domain class name
	@Query("from Student")
	List<Student> findAllStudents();
	
	@Query("select st.firstName,st.lastName from Student st ")
	List<Object[]> findAllStudentPartialData();
	
	@Query("from Student s1 where firstName=:fname")
	List<Student> findAllStudentsByFirstName(@Param("fname") String firstName);
	
	@Query("from Student s1 where lastName=:lname")
	List<Student> findAllStudentsByLastName(@Param("lname") String lastName);

}
