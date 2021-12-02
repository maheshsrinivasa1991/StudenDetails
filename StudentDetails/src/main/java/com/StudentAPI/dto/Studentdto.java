package com.StudentAPI.dto;

import lombok.AllArgsConstructor;
	import lombok.Data;
	import lombok.NoArgsConstructor;
	import lombok.ToString;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@ToString
	public class Studentdto<studentEntity> {
		
		private String firstName;
		private String lastName;
		private String mobilenumber;
		private String email;
		private String project;
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

	}
