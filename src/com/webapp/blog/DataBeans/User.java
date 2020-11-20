package com.webapp.blog.DataBeans;

import org.genericdao.PrimaryKey;

@PrimaryKey("userName")
public class User {
	private String userName;
    private String password;

    public String getPassword()        { return password; }
    public String getUserName()        { return userName; }

    public void setPassword(String s)  { password = s;    }
    public void setUserName(String s)  { userName = s;    }
    
    @Override
    public String toString() {
    	return "Username: "+userName;
    }
}
