package com.StudentAPI.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StudentAPI.enitity.Student;
import com.StudentAPI.exception.RecordNotFoundException;
import com.StudentAPI.repository.Projectrepository;
import com.StudentAPI.repository.Studentrepository;
import com.StudentAPI.service.Studentservice;
import com.StudentAPIRequest.StudentRequest;
import com.studentapicontroller.studentService;

import lombok.Data;

@Data
@RestController
@RequestMapping("/Students")
public class StudentController {
	private static final Logger
	LOGGER=LoggerFactory.getLogger(StudentController.class);
	studentService StudentService;
	

	@Autowired
	private Studentrepository studentrepository;
	@Autowired
	private Projectrepository projectrepository;

		
	@PostMapping("/save")
	public Studentservice<Student> createRegistration(@RequestBody StudentRequest studentRequest)
			throws RecordNotFoundException, Exception {
		LOGGER.info("Inside createRegistration method of StudentController");
		Student Student= new Student(studentRequest);
		boolean isValid = StudentService.isValid(Student);
		if (isValid) {
			return StudentService.createStudent(Student);
		} else {
			throw new RecordNotFoundException("Missing Data Exception");
		}
	}
	
	
	@RequestMapping
	public List<Student> students()
	{
		return Studentservice.getAllStudent();
	}

	
	@GetMapping("/Student/{id}")
	public Student findStudentById(@PathVariable("Id") Long student) throws RecordNotFoundException {
		LOGGER.info("Inside findRegistrationById method of StudentController");
		Student registration = StudentService.findStudentById(student);
		if(registration == null)
			throw new RecordNotFoundException("id: "+ StudentService);
		return registration;
	}
	
	
	@RequestMapping
	public void addStudent (@RequestBody Student student) {
		Studentservice.addStudent(student);
	}



	public Projectrepository getProjectrepository() {
		return projectrepository;
	}


	public void setProjectrepository(Projectrepository projectrepository) {
		this.projectrepository = projectrepository;
	}

	public Studentrepository getStudentrepository() {
		return studentrepository;
	}

	public void setStudentrepository(Studentrepository studentrepository) {
		this.studentrepository = studentrepository;
	}

}

