package com.webapp.blog.DataBeans;

import org.genericdao.PrimaryKey;

@PrimaryKey("postId")
public class PostBean {
	private int postId;
	private String userName, description;
	private String date;
	
	
	public PostBean() {
		super();
	}
	public int getPostId() { return postId; }
	public void setPostId(int postId) { this.postId = postId; }
	
	public String getUserName() { return userName; }
	public void setUserName(String userName) { this.userName = userName; }
	
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	
	public String getDate() { return date; }
	public void setDate(String date) { this.date = date; }
	
	
	
}
