package com.jmv.jdbc.rca;
import java.sql.Date;

public class Student {
	 private int id;
	private String name;
	private int age;
	private Date dob;
	private String school;
	private String code;
	private String email;
    private String mobile;
	public Student(int id, String name, int age, Date dob, String school, String code, String email, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.dob = dob;
		this.school = school;
		
		this.code = code;
		this.email = email;
		this.mobile = mobile;
	}
	public Student(String name, int age, Date dob, String school, String code, String email, String mobile) {
		super();
		this.name = name;
		this.age = age;
		this.dob = dob;
		this.school = school;
		this.code = code;
		this.email = email;
		this.mobile = mobile;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
	