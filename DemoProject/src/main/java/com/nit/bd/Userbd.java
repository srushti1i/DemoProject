package com.nit.bd;


import com.nits.db.UserDao;
import com.nits.model.User;

public class Userbd { 
	
	public static  String addUser(User user) {
		 return UserDao.addUser(user);
		
	}

	public static String updateUser(User user) {;
		return UserDao.updateUser(user);
		
	}
	public static String deleteUser(User user) {
		return UserDao.deleteUser(user);
	}
	public static User getDetails(String username) {
		return UserDao.getDetails(username);
	}
	
	public static boolean Validate(String username, String password) {
		return UserDao.Validate(username, password);
		
	}

}