package com.nit.bd;

import java.util.List;

import com.nits.db.CourseDao;
import com.nits.model.Course;

public class Coursebd {
		public static Course getCourse(String courseCode) {
			return CourseDao.getCourse(courseCode);
		}
		public static List<Course> getAllCourses(){
			
			return CourseDao.getAllCourses();
		}
}
