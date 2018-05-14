package com.edu;

public class MemDTO {

	private String id;
	private String passwd;
	private String name;
	private String birth;
	private String phone;
	private String cdate;
	private String udate;
	
	public MemDTO() {
		
	}


	public MemDTO(String id, String passwd, String name, String birth, String phone, String cdate, String udate) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.birth = birth;
		this.phone = phone;
		this.cdate = cdate;
		this.udate = udate;
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

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getCdate() {
		return cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	public String getUdate() {
		return udate;
	}

	public void setUdate(String udate) {
		this.udate = udate;
	}

	@Override
	public String toString() {
		return "MemDTO [id=" + id + ", passwd=" + passwd + ", name=" + name + ", birth=" + birth + ", phone=" + phone
				+ ", cdate=" + cdate + ", udate=" + udate + "]";
	}

}
