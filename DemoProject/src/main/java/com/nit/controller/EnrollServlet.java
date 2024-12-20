package com.nit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nits.model.User;

/**
 * Servlet implementation class EnrollServlet
 */
@WebServlet("/EnrollServlet")
public class EnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		User user=new User();
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		user=(User) session.getAttribute("user");
		String name=user.getName();
		String courseName=request.getParameter("courseName");
		
		pw.println("<html><body style='background-color:wheat;'>");
		pw.println("<p>Congratulations "+ name+"</p>");
		pw.println("<p>You have successfully enrolled to "+courseName+"</p>");
		pw.println("</body></html>");
		}

}
