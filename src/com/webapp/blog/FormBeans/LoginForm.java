package com.webapp.blog.FormBeans;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

public class LoginForm {
	private String userName;
    private String password;

    public LoginForm(HttpServletRequest request) {
        userName = request.getParameter("userName");
        password = request.getParameter("password");
    }

    public String getUserName() {return userName;}

    public String getPassword() {return password;}

    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();

        if (userName == null || userName.length() == 0) {errors.add("User Name is required");}
        
        if (password == null || password.length() == 0) {errors.add("Password is required");}
        
        if (userName.matches(".*[<>\"].*")) {errors.add("User Name may not contain angle brackets or quotes");}

        return errors;
    }

}
