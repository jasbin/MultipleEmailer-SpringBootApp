package com.emailer.domain;

public class User {
	private Integer id;
	private String Name;
	private String emailAddress;
	private String Course;
	
	public User(){

	}
	
	public User(Integer id, String name, String emailAddress, String course) {
		super();
		this.id = id;
		Name = name;
		this.emailAddress = emailAddress;
		Course = course;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCourse() {
		return Course;
	}
	public void setCourse(String course) {
		Course = course;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
}
