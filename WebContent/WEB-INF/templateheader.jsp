<%@page import="com.webapp.blog.DataBeans.*"%>

<% User[] users = (User[]) request.getAttribute("users"); %>

<%
	for(int i = 0; i < users.length; i++){
		User user = users[i];	
%>
	<form action="visit.do" method="POST">
		<div id="users">
			<div id="avatar"></div>
			<button type="submit" name="user" value="<%=user.getUserName()%>"><%=user.getUserName() %></button>
		</div>
	</form>
<%
	}
%>