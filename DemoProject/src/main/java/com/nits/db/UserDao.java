package com.nits.db;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nits.model.User;

public class UserDao {
	private static final String INSERT_QUERY="INSERT INTO table1(USERNAME,PASSWORD,NAME,GENDER,EDUCATION,DESCRIPTION) VALUE(?,?,?,?,?,?)";
	private static final String UPDATE_QUERY="UPDATE table1 SET name = ?, gender = ?, education = ?, description = ? WHERE username = ? AND password = ?";
	private static final String DELETE_QUERY="DELETE FROM table1 WHERE username= ? ";
	private static final String DETAILS_QUERY="SELECT * from table1 WHERE username=?";
	private static final String VALIDATE_QUERY= "SELECT * from table1 WHERE username=? AND password=?";
	public static String addUser(User user) {
		 
		try(
				Connection con=DbUtil.getConnection();
				PreparedStatement ps=con.prepareStatement(INSERT_QUERY); ){
			    
			    ps.setString(1, user.getUsername());   
		        ps.setString(2, user.getPassword());  
		        ps.setString(3, user.getName());      
		        ps.setString(4, user.getGender());     
		        ps.setString(5, user.getEducation());  
		        ps.setString(6, user.getDescription());
	    		
	    		
	    		int count= ps. executeUpdate();
	    		if(count==0) {
	    		return("<p>Record not submitted</p>");
	    		}else {
	    		return("<p><b>You have successfully registered!!</b></p>");
	    		}
	       }catch(SQLException se) {
	    	   se.printStackTrace();
	    	   return(se.getMessage());
	    	   
	       }catch(Exception e) {
	    	   e.printStackTrace();
	    	   return(e.getMessage());
	    	   
	       }
	}

	public static String updateUser(User user) {
		try(
				Connection con=DbUtil.getConnection();
				 PreparedStatement ps=con.prepareStatement(UPDATE_QUERY);
				)
		{
			 
		        ps.setString(1, user.getName());      
		        ps.setString(2, user.getGender());     
		        ps.setString(3, user.getEducation());  
		        ps.setString(4, user.getDescription());
		        ps.setString(5, user.getUsername());  
		        ps.setString(6, user.getPassword());
		        
		        int count= ps. executeUpdate();
	    		if(count==0) {
	    		return("<p>Record not submitted</p>");
	    		}else {
	    		return("<p><b>Record Successfully Updated!!</b></p>");
	    		}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return(e.getMessage());
		}
		
	}
	public static String deleteUser(User user) {
		
		try(
				Connection con=DbUtil.getConnection();
				PreparedStatement ps =con.prepareStatement(DELETE_QUERY);
				){
				ps.setString(1, user.getUsername());
				int count=ps.executeUpdate();
				if(count==0) {
					return("<p>Record not deleted</p>");
				}else {
					return("<p>Record successfully deleted</p>");
				}
	}catch(SQLException e) {
		e.printStackTrace();
		return(e.getMessage());
	}
	}
	public static User getDetails(String username) {
		User user=null;
		try 
			(Connection con=DbUtil.getConnection();
			PreparedStatement ps=con.prepareStatement(DETAILS_QUERY);){
			 ps.setString(1, username);
			 
			  try (ResultSet rs = ps.executeQuery()) { 
		            if (rs.next()) { 
		                user = new User();
		                user.setUsername(rs.getString("username"));
		                user.setPassword(rs.getString("password"));
		                user.setName(rs.getString("name"));
		                user.setGender(rs.getString("gender"));
		                user.setEducation(rs.getString("education"));
		                user.setDescription(rs.getString("description"));
		            }else {
		            	System.out.println("user is empty");
		            }
		        }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public static boolean Validate(String username, String password) {
		 boolean status = false;

		    try 
		    (
		    		 Connection con=DbUtil.getConnection();
		    		PreparedStatement ps = con.prepareStatement(VALIDATE_QUERY);){
		        
		        ps.setString(1, username.trim());
		        ps.setString(2, password.trim());

		       
		       try( ResultSet rs = ps.executeQuery();){
		        status = rs.next();
		       }
		    } catch (Exception e) {
		            System.out.println("Error closing resources: " + e.getMessage());
		        }
		    return status;
		}
}