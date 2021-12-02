package com.StudentAPI.service;


import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentAPI.dto.Studentdto;
import com.StudentAPI.enitity.Student;
import com.StudentAPI.repository.Studentrepository;



@Service
public class Studentservice<StudentEntity> {
	private static final Logger
	LOGGER=LoggerFactory.getLogger(Studentdto.class);
	
	@Autowired
	Studentrepository repository;

	public static List <Student>getAllStudent(){
		List<Student> allStudent =new ArrayList<Student>();
		Studentrepository.findAll().forEach(s -> allStudent.add(s));
		return allStudent;
		}
	
		public Long findRegistrationById(Long rId, Long StudentId) {
		LOGGER.info("Inside findRegistrationById method of StudentService");
		return Studentrepository.findByStudentRId(StudentId);
	}

	public static void addStudent(Student student) {
		Studentrepository.save(student);
		
		
	}

	

}


