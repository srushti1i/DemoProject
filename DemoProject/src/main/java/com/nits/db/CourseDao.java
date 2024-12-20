package com.nits.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nits.model.Course;

public class CourseDao {
	private static final String DETAILS_QUERY="SELECT * from table2 WHERE course_code=?";
	private static final String COURSES_QUERY="SELECT * from table2";
		public static  Course getCourse(String courseCode) {
			Course course=null;
			try(
					Connection con=DbUtil.getConnection();
					PreparedStatement ps=con.prepareStatement(DETAILS_QUERY);){
				ps.setString(1,courseCode);
				try(ResultSet rs=ps.executeQuery()){
					if(rs.next()) {
						course=new Course();
						course.setCourseCode(rs.getString("course_code"));
						course.setCourseName(rs.getString("course_name"));
						course.setCourseDes(rs.getString("course_des"));
						course.setCoursePrice(rs.getString("course_price"));
						course.setDuration(rs.getString("duration"));
					}else {
						System.out.println("Course not found");
					}
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return course;
		}
	    
		public static List<Course> getAllCourses(){
			List<Course> courses=new ArrayList<>();
			Course course=null;
			try(
					Connection con=DbUtil.getConnection();
					PreparedStatement ps=con.prepareStatement(COURSES_QUERY);
					ResultSet rs=ps.executeQuery();
					){
				while(rs.next()) {
					course=new Course();
					course.setCourseCode(rs.getString("course_code"));
					course.setCourseName(rs.getString("course_name"));
					course.setCourseDes(rs.getString("course_des"));
					course.setCoursePrice(rs.getString("course_price"));
					course.setDuration(rs.getString("duration"));
					courses.add(course);
				}
			}	catch (SQLException e) {
	            e.printStackTrace();
	        }				
			
			return courses;		
			
		}
}

