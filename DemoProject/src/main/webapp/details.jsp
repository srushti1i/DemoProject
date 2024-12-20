<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color:wheat;">
	
<h1>Details</h1>
<p><strong>Name:</strong> ${sessionScope.user.name}</p>
<p><strong>Gender:</strong> ${sessionScope.user.gender}</p>
<p><strong>Education:</strong> ${sessionScope.user.education}</p>
<p><strong>Description:</strong> ${sessionScope.user.description}</p>

<form action="HelloServlet" method="post">
	<input type="hidden" name="fname" value="${sessionScope.user.name}">
        <input type="hidden" name="gender" value="${sessionScope.user.gender}">
        <input type="hidden" name="edu" value="${sessionScope.user.education}">
        <input type="hidden" name="description" value="${sessionScope.user.description}">
        
        
        <button type="submit">Update</button>
       
</form>
<form action="Final.jsp" method="post">
<input type="hidden" name="fname" value="${sessionScope.user.name}">
        <input type="hidden" name="gender" value="${sessionScope.user.gender}">
        <input type="hidden" name="edu" value="${sessionScope.user.education}">
        <input type="hidden" name="description" value="${sessionScope.user.description}">
         <button type="submit">Save</button>
</form>
</body>
</html>