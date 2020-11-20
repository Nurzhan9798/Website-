package com.webapp.blog.blog;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;

import com.webapp.blog.Dao.Model;
import com.webapp.blog.Dao.UserDAO;
import com.webapp.blog.DataBeans.User;
import com.webapp.blog.FormBeans.RegisterForm;

public class Registration extends Action {
    private UserDAO userDAO;
    
    public Registration(Model model) {
    	this.userDAO = model.getUserDao();
    }
    
    @Override
	public String getName() {
		// TODO Auto-generated method stub
		return "registration.do";
	}
    
    public String performGet(HttpServletRequest request) {
        // If user is already logged in, redirect to todolist.do
        HttpSession session = request.getSession();
        try {
			request.setAttribute("users", userDAO.getUsers());
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (session.getAttribute("todolist5_user") != null) {
            return "home.do";
        }
        
        // Otherwise, just display the login page.
        return "registration.jsp";
    }
    

	public String performPost(HttpServletRequest request) {
        // If user is already logged in, redirect to todolist.do
		 try {
				request.setAttribute("users", userDAO.getUsers());
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        HttpSession session = request.getSession();
        if (session.getAttribute("todolist5_user") != null) {
            return "home.do";
        }

        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);

        try {
        	RegisterForm form = new RegisterForm(request);
            request.setAttribute("form", form);

            // Any validation errors?
            errors.addAll(form.getValidationErrors());
            
            if (errors.size() != 0) {
                return "registration.jsp";
            }

            
            // Look up the user
            User user = userDAO.read(form.getUserName());
            if (user != null) {
                errors.add("User already existed");
                return "registration.jsp";
            }

            user = new User();
            user.setUserName(form.getUserName());
            user.setPassword(form.getPassword());
            userDAO.create(user);
            // Attach (this copy of) the user bean to the session
            session.setAttribute("todolist5_user", user);

            return "home.do";
        } catch (RollbackException e) {
            errors.add(e.getMessage());
            return "error.jsp";
        }
    }

	

}
