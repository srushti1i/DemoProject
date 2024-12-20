package com.nit.controller;


import java.io.IOException;
//import java.io.PrintWriter;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nit.bd.Userbd;
import com.nits.model.User;


@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(false);
		String name=(String) request.getParameter("fname");
		String gender= (String) request.getParameter("gender");
		String edu=(String) request.getParameter("edu");
		String des=(String) request.getParameter("description");
		String username=(String) session.getAttribute("username");
		String password=(String) session.getAttribute("password");

		
		
		User user=new User();
		user.setName(name);
		user.setGender(gender);
		user.setEducation(edu);
		user.setDescription(des);
		user.setUsername(username);
		user.setPassword(password);
		
		session.setAttribute("user", user);
		
		String str=Userbd.updateUser(user);
		PrintWriter pw=response.getWriter();
		pw.println(str);
		request.getRequestDispatcher("details.jsp").include(request, response);
		
		

}
}