package com.webapp.blog.FormBeans;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class PostForm {
    private String post;
    private String action;

    public PostForm(HttpServletRequest request) {
        post = request.getParameter("post");
        action = request.getParameter("action");
    }
    
    

    public String getPost() { return post; }
	public String getAction() { return action; }

	public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();

        if (post == null || post.length() == 0) {
            errors.add("Description is required");
        }
        
        if (action == null) {
            errors.add("Action is required");
        } else if (!action.equals("post")) {
            errors.add("Invalid action: " + action);
        }
        
        return errors;
    }
}
