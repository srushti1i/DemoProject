package com.nits.model;

public class User {
	private String username;
	private String password;
	private String name;
	private String gender;
	private String edu;
	private String des;
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setGender(String gender) {
		this.gender=gender;
		
	}
	public String getGender() {
		return gender;
	}
	public void setEducation(String edu) {
		this.edu=edu;
		
	}
	public String getEducation() {
		return edu;
	}
	public void setDescription(String des) {
		this.des=des;
		
	}
	public String getDescription() {
		return des;
	}
	public void setUsername(String username) {
		this.username=username;
		
	}
	public String getUsername() {
		return username;
	}
	public void setPassword(String password) {
		this.password=password;
		
	}
	public String getPassword() {
		return password;
	}
	
}
