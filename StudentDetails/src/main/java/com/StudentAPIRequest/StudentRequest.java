package com.StudentAPIRequest;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.StudentAPI.enitity.Student;
import com.student_details.project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class StudentRequest {
	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	private String mobilenumber;
	private String email;
	private String project;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public String getMobilenumber() {
		return mobilenumber;
	}


	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getProject() {
		return project;
	}


	public void setProject(String project) {
		this.project = project;
	}


	public List<project> getProjects() {
		return projects;
	}


	public void setProjects(List<project> projects) {
		this.projects = projects;
	}


	@OneToMany (targetEntity = project.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "sp_fk", referencedColumnName = "id")
	private List<project>projects;


	public static void save(Student std) {
		StudentRequest.save(std);
		
	}

}



