<%@page import="com.nit.bd.Coursebd,com.nits.model.Course,java.util.List,com.nits.util.TextUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    List<Course> courses=Coursebd.getAllCourses();
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Available courses</title>
<style>
        body {
            font-family: Arial, sans-serif;
        }
        .course-container {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
            gap: 20px;
        }
        .course-card {
            border: 1px solid #ddd;
            border-radius: 8px;
            padding: 15px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            background-color: beige;
        }
        .course-card:hover {
         background-color: #f9f9f9;
         cursor: pointer;
        } 
        .course-card h3 {
            margin: 0 0 10px;
        }
        .course-card p {
            margin: 0 0 5px;
        }
         .course-link {
        display: block;
        text-decoration: none;
        color: inherit;
    }
    </style>
</head>
<body style="background-color:wheat;">
<h1>Courses</h1>
<div class="course-container">
    <% for (Course course : courses) { %>
        <div class="course-card" onclick="window.location='ReadMore.jsp?courseCode=<%= course.getCourseCode() %>'">
            <h3><%= course.getCourseName() %></h3>
            <p><strong>Description:</strong> <%= TextUtil.shortenString(course.getCourseDes(), 50) %></p>
            <p><strong>Price:</strong> <%= course.getCoursePrice() %></p>
        </div>
    <% } %>
</div>

</body>
</html>