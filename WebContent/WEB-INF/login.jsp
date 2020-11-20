<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <header>
      <h1>Blog</h1>
      <p>Share your story!</p>
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
        <h1>Login to your blog</h1>
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
        <form action="login.do" method="POST">
        
	        <table>
	          <tr>
	            <td><h3>Name:</h3></td>
	            <td><input type="text" name="userName" value="${form.userName}"/></td></td>
	          </tr>
	          <tr>
	            <td><h3>Password:</h3></td>
	            <td><input type="password" name="password"/></td></td>
	          </tr>
	          <td colspan="2" align="center"><input class="submit" type="submit" value="Submit"></td>
	        </table>
	  	</form>
      </article>
    </div>

    <footer>
        <h5 >Copyright @Bakytov</h5>
    </footer>
  </body>
</html>