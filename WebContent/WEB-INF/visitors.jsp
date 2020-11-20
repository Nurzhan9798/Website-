<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        <a href="<%= request.getContextPath() %>/view/Home" >Home</a>
        <a href="<%= request.getContextPath() %>/view/Login" >Logout</a>
      </div>
      
    </header>
    
    <div class="content">
    	<article class="sidebar">
      		<jsp:include page="templateheader.jsp" />
      	</article>
      	
      	<article class="main">
        <h3>User's Home Page</h3>
        <div class="post">
        	<h4 class="title">User</h4>Posted on August 19, 2017 12:00 pm
        	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum pellentesque maximus mattis. Sed enim lorem, 
        		tristique nec iaculis bibendum, molestie non arcu. Nam varius dui dolor, id elementum erat ornare quis. Curabitur 
        		aliquam sodales eleifend. Nulla facilisi. Vestibulum condimentum finibus ultricies. Aliquam sit amet lorem ac neque 
        		condimentum dictum. Nunc nec arcu at arcu fermentum iaculis quis quis quam. Praesent congue dolor sit amet molestie dictum. 
        		Curabitur convallis risus et lacus eleifend suscipit.</p>
        	<div class="comment">
        		<input value="X" type="button">
        		<h4 class="title">Comment User</h4>Commented on August 20, 2017 9:35 pm
        		<p>Some comments</p>
        		
        	</div>
        	<div class="comment">
        		<input value="X" type="button">
        		<h4 class="title">Comment User</h4>Commented on August 20, 2017 9:35 pm
        		<p>Some comments</p>
        		
        	</div>
        	<div class="comment">
        		<input value="X" type="button">
        		<h4 class="title">Comment User</h4>Commented on August 20, 2017 9:35 pm
        		<p>Some comments</p>
        		
        	</div>
        	<textarea rows="4" cols="50"></textarea><input type="button" value="Comment">	
        </div>
        <div class="post">
        	<h4 class="title">User</h4>Posted on August 19, 2017 12:00 pm
        	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum pellentesque maximus mattis. Sed enim lorem, 
        		tristique nec iaculis bibendum, molestie non arcu. Nam varius dui dolor, id elementum erat ornare quis. Curabitur 
        		aliquam sodales eleifend. Nulla facilisi. Vestibulum condimentum finibus ultricies. Aliquam sit amet lorem ac neque 
        		condimentum dictum. Nunc nec arcu at arcu fermentum iaculis quis quis quam. Praesent congue dolor sit amet molestie dictum. 
        		Curabitur convallis risus et lacus eleifend suscipit.</p>
        	<div class="comment">
        		<input value="X" type="button">
        		<h4 class="title">Comment User</h4>Commented on August 20, 2017 9:35 pm
        		<p>Some comments</p>
        		
        	</div>
        	<div class="comment">
        		<input value="X" type="button">
        		<h4 class="title">Comment User</h4>Commented on August 20, 2017 9:35 pm
        		<p>Some comments</p>
        		
        	</div>
        	<div class="comment">
        		<input value="X" type="button">
        		<h4 class="title">Comment User</h4>Commented on August 20, 2017 9:35 pm
        		<p>Some comments</p>
        		
        	</div>
        	<textarea rows="4" cols="50"></textarea><input type="button" value="Comment">	
        </div>
        
      </article>
    </div>

    <footer>
        <h5>Copyright @Bakytov</h5>
    </footer>
  </body>
</html>