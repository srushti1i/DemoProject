package com.nits.model;

public class Course {
	private String courseCode;
	private String courseName;
	private String courseDes;
	private String coursePrice;
	private String duration;
	public void setCourseCode(String courseCode) {
		this.courseCode=courseCode;
		
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseName(String courseName) {
		this.courseName=courseName;
		
	}public String getCourseName() {
		return courseName;
	}
	public void setCourseDes(String courseDes) {
		this.courseDes=courseDes;
		
	}
	public String getCourseDes() {
		return courseDes;
		
	}
	public void setCoursePrice(String coursePrice) {
		this.coursePrice=coursePrice;
		
	}
	public String getCoursePrice() {
		return coursePrice;
		
	}
	public void setDuration(String duration) {
		this.duration=duration;
		
	}
	public String getDuration() {
		return duration;
		
	}
}
