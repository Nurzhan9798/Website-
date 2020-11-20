package com.webapp.blog.FormBeans;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class CommentForm {
	private String comment;
    private String action;

    public CommentForm(HttpServletRequest request) {
        comment = request.getParameter("comment");
        action = request.getParameter("action");
    }
    
    

    public String getComment() { return comment; }
	public String getAction() { return action; }

	public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();

        if (comment == null || comment.length() == 0) {
            errors.add("Comment is required");
        }
        
        if (action == null) {
            errors.add("Action is required");
        } else if (!action.equals("comment")) {
            errors.add("Invalid action: " + action);
        }
        
        return errors;
    }

}
