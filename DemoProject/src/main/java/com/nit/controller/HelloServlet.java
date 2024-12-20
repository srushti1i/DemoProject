package com.nit.controller;


import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nits.model.User;


//@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
			User user=new User();
		    String name = request.getParameter("fname");
	        String gender = request.getParameter("gender");
	        String edu = request.getParameter("edu");
	        String description = request.getParameter("description");
	        
	        user.setName(name);
	        user.setGender(gender);
	        user.setEducation(edu);
	        user.setDescription(description);
	       session.setAttribute("user",user);
	        request.getRequestDispatcher("Welcome.jsp").forward(request, response);
	    }
	

	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     
	        response.sendRedirect("Login.html");
	        
}
}