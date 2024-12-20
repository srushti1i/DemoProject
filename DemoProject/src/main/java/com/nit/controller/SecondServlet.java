package com.nit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nit.bd.Userbd;
import com.nits.model.User;
import com.nits.util.DateUtil;

//@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("fname");
        String gender = request.getParameter("gender");
        String edu = request.getParameter("edu");
        String des = request.getParameter("description");

        // Determine greeting based on time
        LocalTime t = LocalTime.now();
        LocalTime noon = LocalTime.of(12, 0);
        LocalTime eve = LocalTime.of(16, 0);
        String str;
        if (t.isBefore(noon)) {
            str = "Good Morning";
        } else if (t.isBefore(eve)) {
            str = "Good Afternoon";
        } else {
            str = "Good Evening";
        }

        // Create User object and save
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setGender(gender);
        user.setEducation(edu);
        user.setDescription(des);

        String statusMessage = Userbd.addUser(user);

        String currentDateTime = DateUtil.DateTime();
        pw.println("<html>");
        pw.println("<head><title>User Greeting</title></head>");
        pw.println("<body style='background-color:wheat;'>");
        pw.printf("<p>%s</p>", statusMessage);
        pw.printf("<p>%s</p>", currentDateTime);
        pw.printf("<p>%s, %s</p>", str, name);
        pw.println("<p><b><a href='Login.html'>To continue into the webpage</a></b></p>");
        pw.println("</body></html>");

        pw.close();
    }
}
