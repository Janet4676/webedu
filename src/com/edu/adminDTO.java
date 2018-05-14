package com.edu;

public class adminDTO {
	private String id, passwd, name, phone, email, grade;
	
	public adminDTO() {
		
	}

	public adminDTO(String id, String passwd, String name, String phone, String email, String grade) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.grade = grade;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
