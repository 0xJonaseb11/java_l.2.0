package models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity 
public class Student {
	
	@Id
	private int id;
	private String name;
	private String email;
	public Student(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public Student() {
		super();
	}

	public int getId() { Hide features ￼ Fullscreen

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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
