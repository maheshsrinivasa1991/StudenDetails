package com.StudentAPI.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StudentAPI.enitity.Student;
import com.StudentAPIRequest.StudentRequest;

public class Studentrepository {

      public static List<Student>getAllStudent(){
	List<Student>allStudent =new ArrayList<Student>();
	return allStudent;
	}
     

	public static void save(Student std) {
		StudentRequest.save(std);
	}

	public Iterable<Student> findAll() {
		List<Student>allStudent =new ArrayList<Student>();
		return allStudent;
		}

@Repository
	public interface StudentRepository1 extends JpaRepository<Student, Long> {
		Student findByStudentId(Long Student);

	}

public static Long findByStudentRId(Long rId) {
	// TODO Auto-generated method stub
	return null;
}

	}


