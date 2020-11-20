
<%@page import="com.webapp.blog.DataBeans.*"%>
<%@page import="java.util.*"%>
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
        <a href="<%= request.getContextPath() %>/home.do" >Home</a>
        <a href="<%= request.getContextPath() %>/logout.do" >LogOut</a>
      </div>
      
    </header>
    
    <div class="content">
    	<article class="sidebar">
      		<jsp:include page="templateheader.jsp" />
      	</article>
      	
      	<article class="main">
<%
	List<String> errors = (List<String>) request.getAttribute("errors");
	if (errors != null) {
		for (String error : errors) {
%>		
			<p> <%= error %> </p>
<%
		}
	}
%>
      	
<%		User user = (User) (request.getSession()).getAttribute("todolist5_user"); %>
        <h1><%=user.getUserName() %>'s Home Page</h1>
        
        <div id="new__post">
			<h3>New Post</h3>
			<form  method="POST" action="post.do">
		
				<textArea name="post" cols="100%" rows="5"></textArea><br>
				<button type="submit" name="action" value="post">Publish</button>
			</form>
		</div>
        
<% PostBean[] posts = (PostBean[]) request.getAttribute("posts");%>
<%
		
        for (int i = 0; i < posts.length; i++) {
            PostBean post = posts[i];
            
%>			
			<div id="post">
				<form method="POST" action="delete.do"> 
					<input value="<%=post.getPostId()%>" type="hidden" name="id">
					<div id="post__title">
						<div id="avatar"></div>
						<div>
							<h3><%=post.getUserName()%></h3> 
							<p>Posted on <%=post.getDate() %><button type="submit">X</button></p>
						</div>
					</div>
					<div id="post__desciption">
						<p><%= post.getDescription()%></p>
					</div>
				</form>
				
				<hr>

				
			

        	<% CommentBean[] comments = (CommentBean[]) request.getAttribute("comments");%>
        	<%
				
		        for (int j = 0; j < comments.length; j++) {
		            CommentBean comment = comments[j];
		            if(comment.getPostId() != post.getPostId()){
		            	continue;
		            }
		            
			%>
	        	<div id="comment">
					<form method="POST" action="deleteHomeComment.do"> 
						<input value="<%=comment.getCommentId()%>" type="hidden" name="id">
						<div id="comment__content">
							<div id="avatar"></div>
							<div>
								<hr>
								<h4><%=comment.getUserName()%></h4> 
								<p><%= comment.getDescription()%></p>
								<span> Commented on <%=comment.getDate() %></span> <button type="submit">X</button>
							</div>
						</div>
					</form>	
					
				</div>
						
	        	
			<%
				}
			%>
        	<form  method="POST" action="comment.do">
				<input value="<%=post.getPostId()%>" type="hidden" name="postId">
				<div id="comment__content__post">
					<div id="avatar"></div>
					<textArea name="comment" cols="100%" rows="1"></textArea>
					<button type="submit" name="action" value="comment">></button>
				</div>
			</form>
		</div>        
<%
        }
%>
        
        
       
        
      </article>
    </div>

    <footer>
        <h5>Copyright @Bakytov</h5>
    </footer>
  </body>
</html>