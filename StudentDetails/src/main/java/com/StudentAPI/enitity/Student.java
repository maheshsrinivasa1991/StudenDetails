package com.StudentAPI.enitity;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.StudentAPIRequest.StudentRequest;
import com.UserRegistration.model.Role;
import com.UserRegistration.model.User;
import com.student_details.project;
import com.studentapidto.studentdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="studentes")
@SQLDelete(sql="UPDATE User SET deleted=true WHERE id=?")
@Where(clause ="deleted=false")
public class Student {

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="mobilenumber")
	private String mobilenumber;
	
	@Column(name="email")
	private String email;
	
	private String project;
	
	private boolean deleted = Boolean.FALSE;
	
	
	public String getFirstName() {
		return firstName;
	}

	public Student(Long id, String firstName, String lastName, String mobilenumber, String email, String project,
			List<com.student_details.project> projects) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobilenumber = mobilenumber;
		this.email = email;
		this.project = project;
		this.projects = projects;
	}
	

	public Student(StudentRequest studentRequest) {
		Student Student= new Student(studentRequest);
	}

	@Override
	public String toString() {
		
	
		return "Student @Column(name=\"firstName\")[id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mobilenumber="
				+ mobilenumber + ", email=" + email + ", project=" + project + ", projects=" + projects + "]";
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	private String Name;

	
	public String getName() {
		return lastName;
	}

	public void setLastName(String Name) {
		this.setName(Name);
	}
	 @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinTable(
	        name = "students_roles",
	        joinColumns = @JoinColumn(
	            name = "student_id", referencedColumnName = "id"),
	        inverseJoinColumns = @JoinColumn(
	            name = "role_id", referencedColumnName = "id"))

	    private Collection < Role > roles;
	private Object state;
	private Student student;

	    public Student() {

	    }

		public Student getStudent() {
			return student;
		}

		public void setStudent(Student student) {
			this.student = student;
		}

		public Object getState() {
			return state;
		}

		public void setState(Object state) {
			this.state = state;
		}

		public void setName(String name) {
			Name = name;
		}
}
