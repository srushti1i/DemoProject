package com.nit.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nit.bd.Userbd;
import com.nits.model.User;

@WebServlet("/ValidationServlet")
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ValidationServlet() {
        super();
    }

		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		
		String u=request.getParameter("username");
		String p=request.getParameter("password");
		
		
		if(Userbd.Validate(u,p)) {
			 HttpSession session = request.getSession();
			    session.setAttribute("username", u);
			    session.setAttribute("password", p);
			    User user=Userbd.getDetails(u);
			    if (user == null) {
			        pw.println("<p style=\"color:red;\">User details not found.</p>");
			        RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			        rd.include(request, response);
			        return; // Stop further execution
			    }
			    session.setAttribute("user", user);
			    
			RequestDispatcher rd=request.getRequestDispatcher("details.jsp");
			rd.forward(request, response);
			
		}else {
			
			pw.println("<p style=\"color:red;\">Wrong Username or Password</p>");
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.include(request, response);
			
		}
		
	}

}
