<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css"></head>
<body style="margin: 0; padding: 0">
    <header >
      <h1 align="center">Blog</h1>
      <p align="center">Share your story!</p>
      <div>
        <a href="<%= request.getContextPath() %>/login.do" >Login</a>
        <a href="<%= request.getContextPath() %>/registration.do" >Register</a>
      </div>
      
    </header>
    <div class="content">
      <article class="sidebar">
      	<jsp:include page="templateheader.jsp" />
      </article>
      <article class="main">
        <h1>Register to the Blog</h1>
<%
		List<String> errors = (List<String>) request.getAttribute("errors");
		if (errors != null) {
			for (String error : errors) {
%>		
				<h3 style="color:red"> <%= error %> </h3>
<%
			}
		}
%>	
        <form action="registration.do" method="post">
        
        	<table>
	          <tr>
	            <td><h3>Username:</h3></td>
	            <td><input type="text" name="userName" value="${form.userName}"/></td>
	          </tr>
	          <tr>
	            <td><h3>Password:</h3></td>
	            <td><input type="password" name="password"/></td>
	          </tr>
	          <tr>
	            <td><h3>CPassword:</h3></td>
	            <td><input type="password" name="cpassword"/></td>
	          </tr>
	          <tr>
	            <td><h3>Firstname:</h3></td>
	            <td><input type="text" name="firstname"/></td>
	          </tr>
	          <tr>
	            <td><h3>Lastname:</h3></td>
	            <td><input type="text" name="lastname"/></td>
	          </tr>
	          <td colspan="2" align="center"><input class="submit" type="submit" value="Submit"></td>
	        </table>
        </form>
        
      </article>
    </div>

    <footer>
        <h5>Copyright @Bakytov</h5>
    </footer>
  </body>
</html>