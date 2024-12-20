<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>


<head>
  <meta charset="UTF-8">
  <title>Form Table</title>
</head>
<body style="background-color: wheat;">
<h1>New User Registration</h1>
 <% if (request.getAttribute("errorMsg") != null) { %>
        <p style="color: red; font-weight: bold;"><%= request.getAttribute("errorMsg") %></p>
    <% } %>
  <form action="SecondServlet" method="post">
    <table >
      <tr>
        <td><label for="fname">First Name:</label></td>
        <td><input type="text" id="fname" name="fname" value="<%=request.getAttribute("fname")!=null?request.getAttribute("fname"):"" %>" required></td>
      </tr>
      <tr>
        <td><label for="username">User Name:</label></td>
        <td><input type="text" id="username" name="username" required></td>
      </tr>
      <tr>
        <td><label for="password">Password:</label></td>
        <td><input type="password" id="password" name="password" required></td>
      </tr>
      <tr>
        <td><label for="gender">Gender:</label></td>
        <td>
          <input type="radio" id="gen1" name="gender" value="F" <%="F".equals(request.getAttribute("gender"))?"checked":"" %>>
          <label for="gen1">Female</label>
          <input type="radio" id="gen2" name="gender" value="M"  <%="M".equals(request.getAttribute("gender"))?"checked":"" %>>
          <label for="gen2">Male</label>
        </td>
      </tr>
      <tr>
        <td><label for="edu">Education:</label></td>
        <td>
          <select name="edu" id="edu">
          	 <option value="High_School"  <%="High_School".equals(request.getAttribute("edu"))?"selected":"" %>>High School</option>
    		 <option value="Bachelors"  <%="Bachelors".equals(request.getAttribute("edu"))?"selected":""%>>Bachelor's degree</option>
    		 <option value="Masters" <%="Masters".equals(request.getAttribute("edu"))?"selected":""%>>Master's degree</option>
    		 <option value="Doctorate" <%="Doctorate".equals(request.getAttribute("edu"))?"selected":""%>>Doctorate</option>
            
          </select>
        </td>
      </tr>
      <tr>
        <td><label for="description">Description:</label></td>
        <td><textarea name="description" rows="5" cols="30"><%=request.getAttribute("description")!=null?request.getAttribute("description"):"" %></textarea></td>
      </tr>
      <tr>
        <td colspan="2" style="text-align: center;">
          <button type="submit">Submit</button>
        </td>
      </tr>
    </table>
  </form>
</body>
</html>