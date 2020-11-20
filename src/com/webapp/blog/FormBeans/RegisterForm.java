package com.webapp.blog.FormBeans;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;


public class RegisterForm {
	private String userName;
    private String password;
    private String cpassword;
    private String fName;
    private String lName;

    public RegisterForm(HttpServletRequest request) {
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        cpassword = request.getParameter("cpassword");
        fName = request.getParameter("firstname");
        lName = request.getParameter("lastname");
    }

    public String getUserName() {return userName;}

    public String getPassword() {return password;}

    public String getCPassword() {return cpassword;}
    
    public String getFName() {return fName;}
    
    public String getLName() {return lName;}

    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();
        Pattern valid = 
        	    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);	
	    Matcher matcher = valid.matcher(userName);
	    if(!matcher.find()) {
	    	errors.add("UserName is incorrect! \n User Name must be like ****@*****.**");
	    }
        	

        if (userName == null || userName.length() == 0) {errors.add("User Name is required");}
        
        if (password == null || password.length() == 0) {errors.add("Password is required");}
        
        if (cpassword == null || cpassword.length() == 0) {errors.add("confirmation password is required");}
        if (fName == null || fName.length() == 0) {errors.add("First name is required");}
        if (lName == null || lName.length() == 0) {errors.add("Last name is required");}
        
        if (userName.matches(".*[<>\"].*")) {errors.add("User Name may not contain angle brackets or quotes");}
        
        if( !password.equals(cpassword)) {errors.add("Password should match");}

        return errors;
    }

	
}
