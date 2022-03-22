package com.springdata.jpqlandnativesql;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springdata.jpqlandnativesql.entity.Student;
import com.springdata.jpqlandnativesql.repository.StudentRepository;

@SpringBootTest
class JpqlandnativesqlApplicationTests {

	@Autowired
	StudentRepository studentRepository;

	@Test
	void insertData() {

		Student student = new Student();
		student.setFirstName("Nitish");
		student.setLastName("Govekar");
		student.setScore(88);
		studentRepository.save(student);

		Student student2 = new Student();
		student2.setFirstName("Ranveer");
		student2.setLastName("Singh");
		student2.setScore(60);
		studentRepository.save(student2);
	}

	@Test
	void printAllStudentRecords() {
		System.out.println(studentRepository.findAllStudents());
	}

	@Test
	void printAllStudentPartialRecords() {
		List<Object[]> objects = studentRepository.findAllStudentPartialData();

		for (Object object[] : objects) {
			System.out.println("FirstName: " + object[0] + " LastName: " + object[1]);
		}
	}

	@Test
	void findByFirstName() {
		System.out.println(studentRepository.findAllStudentsByFirstName("Nitish"));
	}

	@Test
	void findByLastName() {
		System.out.println(studentRepository.findAllStudentsByLastName("Singh"));
	}

	@Test
	void findByMinMaxScore() {
		System.out.println(studentRepository.findAllStudentByMinMaxScores(80, 90));
	}

	@Test
	@Transactional
	void deleteStudentRecord() {
		studentRepository.deleteFromStudent("Nitish");
	}
	
	@Test
	void printAllRecordsNQ() {
		System.out.println(studentRepository.findAllStudentNQ());
	}
}
