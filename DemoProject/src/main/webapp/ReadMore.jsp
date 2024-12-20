<%@page import="com.nit.bd.Coursebd,com.nits.model.Course"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String courseCode=request.getParameter("courseCode");
    Course course=Coursebd.getCourse(courseCode);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course details</title>
</head>
<body style="background-color:wheat">
<form action="EnrollServlet" method="post">
<h2><%=course.getCourseName() %></h2>
<p><%=course.getCourseDes() %></p>
<p><strong>Price:</strong> <%= course.getCoursePrice() %></p>
<p><strong>Duration:</strong> <%=course.getDuration() %></p>
<input type="hidden" name="courseCode" value="<%=course.getCourseCode() %>">
<input type="hidden" name="courseName" value="<%=course.getCourseName() %>">
<button type="submit">Enroll</button>
</form>

</body>
</html>