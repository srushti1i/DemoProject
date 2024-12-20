<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Page</title>
</head>
<body style="background-color:wheat;">
<form action="UpdateUserServlet" method="post">
  <label for="fname">First name:</label><br>
  <input type="text" id="fname" name="fname" value="${sessionScope.user.name!=null? sessionScope.user.name:''}" required><br>
  
  <label for="gender">Gender:</label><br>
  <input type="radio" id="gen1" name="gender" value="F" ${sessionScope.user.gender=='F'?'checked':' ' }>
  <label for="gen1">Female</label>
  <input type="radio" id="gen2" name="gender" value="M" ${sessionScope.user.gender=='M'?'checked':' ' } >
  <label for="gen2">Male</label><br>
  
  <label for="edu">Education:</label>
  <select name="edu" id="edu">
    <option value="High_School" ${sessionScope.user.education=='High_School'?'selected':' ' }>High School</option>
    <option value="Bachelors" ${sessionScope.user.education=='Bachelors'?'selected':' ' }>Bachelor's degree</option>
    <option value="Masters" ${sessionScope.user.education=='Masters'?'selected':' ' }>Master's degree</option>
    <option value="Doctorate" ${sessionScope.user.education=='Doctorate'?'selected':' ' }>Doctorate</option>
  </select><br>
  
  <label for="description">Description:</label><br>
  <textarea name="description" rows="10" cols="30">${sessionScope.user.description!=null? sessionScope.user.description:''}</textarea><br>
  
  <button type="submit">Submit</button>
</form>
</body>
</html>
